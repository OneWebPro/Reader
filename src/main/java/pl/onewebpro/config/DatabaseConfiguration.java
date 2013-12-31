package pl.onewebpro.config;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.EbeanServerFactory;
import com.avaje.ebean.config.DataSourceConfig;
import com.avaje.ebean.config.ServerConfig;
import pl.onewebpro.helpers.MD5;

import java.io.IOException;

public class DatabaseConfiguration {

    private ServerConfig config = new ServerConfig();
    private DataSourceConfig dataSourceConfig = new DataSourceConfig();
    private EbeanServer server;


    public DatabaseConfiguration(Config instance) throws IOException {
        config.setName("db");
        dataSourceConfig.setDriver("org.h2.Driver");
        dataSourceConfig.setUsername(instance.getData().user);
        dataSourceConfig.setPassword(MD5._(instance.getData().user));
        dataSourceConfig.setUrl("jdbc:h2:" + instance.getPath().getMainPath() + PathConfiguration.DS + "db");
        config.setDataSourceConfig(dataSourceConfig);
        config.setDdlGenerate(true);
        config.setDdlRun(true);
        config.setDefaultServer(false);
        config.setRegister(false);
        server = EbeanServerFactory.create(config);
    }

    public ServerConfig getConfig() {
        return config;
    }

    public DataSourceConfig getDataSourceConfig() {
        return dataSourceConfig;
    }

    public EbeanServer getServer() {
        return server;
    }
}
