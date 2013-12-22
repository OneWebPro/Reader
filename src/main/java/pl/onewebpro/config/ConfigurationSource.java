package pl.onewebpro.config;

import org.xmappr.Element;
import org.xmappr.RootElement;

/**
 * Created by loki on 22.12.13.
 */
@RootElement("configuration")
public class ConfigurationSource {

    @Element(defaultValue  = "00.00.01")
    public String version;

    @Element(defaultValue  = "develop")
    public String deploy = "develop";

    public String user = System.getProperty("user.name");

}
