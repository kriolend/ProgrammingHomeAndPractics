package ua.org.oa.rumyancevv.practics8.properties;

import java.io.*;
import java.util.Properties;

/**
 * Created by dmitr on 26.02.2016.
 */
public class PropertyUtils {
    private static String propertiesFilePath = "App.properties";
    private static Properties properties = null;

    public static Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            try (InputStream in = new FileInputStream(new File(propertiesFilePath))) {
                properties.load(in);
            } catch (IOException e) {
               e.printStackTrace();
            }
        }
        return properties;
    }
}
