package helpers;

import java.util.Properties;

public class ConfigProperties {
    private static Properties properties;
    public final static String PROPERTIES_PATH = "src/main/resources/config.properties";

    public static String get(String key) {
        if (properties == null) {
            properties = FileUtils.loadProperties(PROPERTIES_PATH);
            return properties.getProperty(key);
        }
        return properties.getProperty(key);
    }

}
