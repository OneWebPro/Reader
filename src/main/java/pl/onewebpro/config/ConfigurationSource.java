package pl.onewebpro.config;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "configuration")
public class ConfigurationSource {

    @XmlAttribute
    public String version = "00.00.01";

    @XmlAttribute
    public String deploy = "develop";

    public String user = System.getProperty("user.name");

}
