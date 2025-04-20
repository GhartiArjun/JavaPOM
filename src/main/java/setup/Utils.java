package setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utils {
    public static void pauseExecutionForSeconds(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static Properties loadProperties() {
        Properties property = new Properties();
        //System.getProperty("user.dir");
        String propertyFilePath ="/Users/sumanarai/Documents/JavaPOM/src/main" +
                "/java/setup/config.properties";
        try (FileInputStream input = new FileInputStream(propertyFilePath)) {
            property.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property;
    }


    public static String getProperties(String propertyName){
        return loadProperties().getProperty(propertyName).trim();
    }
}
