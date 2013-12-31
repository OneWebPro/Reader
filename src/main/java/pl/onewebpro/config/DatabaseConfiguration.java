package pl.onewebpro.config;

import org.hibernate.cfg.Configuration;
import pl.onewebpro.helpers.MD5;

import java.io.IOException;

public class DatabaseConfiguration {

    private String url = "";
    private Configuration config = null;

    public DatabaseConfiguration(Config instance) throws IOException {
        this.url = "jdbc:derby:" + instance.getPath().getConfigPath() + "data" + PathConfiguration.DS + "db;create=true";
        String user = "admin";
        String pass = "admin";
        String schema = "ADMIN";
        config = new Configuration()
                .setProperty("hibernate.connection.url", this.url)
                .setProperty("hibernate.default_schema",schema)
                .setProperty("hibernate.connection.username",user)
                .setProperty("hibernate.connection.password",pass)
                .configure(getClass().getResource("../../../hibernate.cfg.xml"));
    }

}
