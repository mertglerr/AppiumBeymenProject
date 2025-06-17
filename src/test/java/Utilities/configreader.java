package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class configreader {

    private static Properties properties;

    static {
        String path = "configuration.properties";

        try{
            FileInputStream file = new FileInputStream(path);
            properties = new Properties();
            properties.load(file);
            file.close();
        }
        catch (Exception e) {
            System.out.println("Congurations file is not exist");
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }


}
