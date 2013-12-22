package pl.onewebpro.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xmappr.Xmappr;

import java.io.*;

/**
 * Created by loki on 22.12.13.
 */
public class Config {

    public static Config instance;

    private PathConfiguration path;

    private DatabaseConfiguration db;

    private ConfigurationSource data;

    private File configFile;

    Logger log = LoggerFactory.getLogger(Config.class);

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
        } catch (IOException e) {
            log.error("Configuration error", e);
        }
        this.db = new DatabaseConfiguration(instance);
    }

    private void loadConfigurationFile() throws IOException {
        Reader xmlConfigReader = new FileReader(configFile);
        Xmappr xm;
        if (configFile.exists()) {
            xm = new Xmappr(xmlConfigReader);
            data = (ConfigurationSource) xm.fromXML(xmlConfigReader);
        } else if (!configFile.exists()) {
            if (configFile.createNewFile()) {
                xm = new Xmappr(ConfigurationSource.class);
                data = (ConfigurationSource) xm.fromXML(xmlConfigReader);
            }
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
