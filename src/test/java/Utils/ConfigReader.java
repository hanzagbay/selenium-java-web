package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static Properties properties;

    static {
        try {
            FileInputStream fis = new FileInputStream("src/test/resource/config.properties");
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not load config.properties");
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
