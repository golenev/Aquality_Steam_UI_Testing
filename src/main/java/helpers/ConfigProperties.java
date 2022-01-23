package helpers;


import java.util.Properties;

public class ConfigProperties {
    private static Properties properties;

    public static String get(String key) {
        if (properties == null) {
            properties = FileUtils.loadProperties("src/main/resources/config.properties");
            return properties.getProperty(key);
        }
        return properties.getProperty(key);
    }

}
