package pl.onewebpro.config;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class Config {

    public static Config instance;

    private PathConfiguration path;

    private DatabaseConfiguration db;

    private ConfigurationSource data;

    private File configFile;

    private Logger log = LoggerFactory.getLogger(Config.class);

    public static Config app() {
        if (instance == null) {
            synchronized (Config.class) {
                if (instance == null) {
                    instance = new Config();
                    instance.load();
                }
            }
        }
        return instance;
    }

    private void load() {
        this.path = new PathConfiguration();
        this.configFile = this.path.getConfigFile();
        try {
            this.loadConfigurationFile();
            this.db = new DatabaseConfiguration(instance);
        } catch (IOException | JAXBException e) {
            log.error("Configuration error", e);
        }
    }

    private void loadConfigurationFile() throws IOException, JAXBException {
        JAXBContext jaxContext = JAXBContext.newInstance(ConfigurationSource.class);
        if (!configFile.exists()) {
            data = new ConfigurationSource();
            FileUtils.forceMkdir(new File(configFile.getParent()));
            Marshaller m = jaxContext.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(data, configFile);
        } else {
            Unmarshaller um = jaxContext.createUnmarshaller();
            data = (ConfigurationSource) um.unmarshal(new FileReader(configFile));
        }
    }

    public PathConfiguration getPath() {
        return path;
    }

    public DatabaseConfiguration getDb() {
        return db;
    }

    public ConfigurationSource getData() {
        return data;
    }
}
