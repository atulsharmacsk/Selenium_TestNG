package Utils;

import java.io.*;
import java.util.Properties;

public class ConfigReader {

    private Properties prop;

    public ConfigReader(){
        prop=new Properties();
        BufferedReader reader= null;
        String propertyFilePath=".//src//main//resources//config.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            prop.load(reader);
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof FileNotFoundException)
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getURL(){
        switch(System.getProperty("ENV")){
            case "SIT":
                return prop.getProperty("sit_url");
            case "DEV":
                return prop.getProperty("dev_url");
            case "UAT":
                return prop.getProperty("uat_url");
            default:
                throw new RuntimeException("please specify one of sit_url, dev_url or uat_url");
        }
    }


}
