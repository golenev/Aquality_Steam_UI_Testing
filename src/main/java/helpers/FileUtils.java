package helpers;

import aquality.selenium.core.logging.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtils {
    public static boolean propertyFileExists(String path) {
        return new File(path).exists();
    }
    public static Properties loadProperties(String path) {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(path)) {
            Logger.getInstance().debug("Loading configuration file: " + path);
            properties.load(fis);
        } catch (IOException e) {
            Logger.getInstance().debug("Не удалось считать Properties");
          throw new RuntimeException("Не удалось считать Properties");
        }
        return properties;
    }
}
