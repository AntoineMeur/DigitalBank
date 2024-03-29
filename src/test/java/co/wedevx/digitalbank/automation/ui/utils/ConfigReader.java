package co.wedevx.digitalbank.automation.ui.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        String filePath = "src/test/resources/properties/digitalbank.properties";

        FileInputStream input = null;

        try {
            input = new FileInputStream(filePath);
            properties = new Properties();
            properties.load(input);
        } catch (IOException e){
            System.out.println("file not found");
        }
         finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static String getPropertiesValue(String key){
        return properties.getProperty(key);
    }

    public static void main(String[] args) {
        String key = getPropertiesValue("browser");
        System.out.println(key);

    }

}
