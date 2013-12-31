package pl.onewebpro.config;

import java.io.File;

public class PathConfiguration {

    public static final String BASE_DIR_LINUX = System.getProperty("user.home");

    public static final String BASE_DIR = System.getenv("APPDATA");

    public static final String OS = System.getProperty("os.name");

    public static final String DS = System.getProperty("file.separator");

    public static final String CONFIG_FILE_NAME = "config.xml";

    public static final String NAME = "OneWebPro Reader";

    /**
     * Empty constructor
     */
    public PathConfiguration() {
    }

    /**
     * Method return a path for config files
     *
     * @return String
     */
    public String getMainPath() {
        if (this.isWindows()) {
            return BASE_DIR + DS + NAME;
        } else {
            if (this.isLinux()) {
                return BASE_DIR_LINUX + DS + "." + NAME;
            }
        }
        return BASE_DIR;
    }

    /**
     * Method return if system is Windows
     *
     * @return boolean
     */
    public boolean isWindows() {
        return OS.toUpperCase().contains("WIND");
    }

    /**
     * Method return if system is Linux
     *
     * @return boolean
     */

    public boolean isLinux() {
        return OS.toUpperCase().contains("LIN");
    }

    /**
     * Return full config path
     *
     * @return String
     */
    public String getConfigPath() {
        return this.getMainPath() + DS + "system" + DS;
    }

    public String getConfigFilePath() {
        return this.getConfigPath() + CONFIG_FILE_NAME;
    }

    /**
     * Return config File instance using getConfigPath(); method.
     *
     * @return File
     */
    public File getConfigFile() {
        return new File(this.getConfigFilePath());
    }


}
