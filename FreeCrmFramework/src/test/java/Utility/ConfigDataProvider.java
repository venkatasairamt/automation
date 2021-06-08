package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider {
    Properties pro;

    //create a constructor
    public ConfigDataProvider(){
        File src = new File("./Config/config.properties");

        try{
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);

        } catch (Exception e) {
            System.out.println("Not able to load config file"+e.getMessage());
        }
    }

    // create methods
    public String getBrowser(){
        return pro.getProperty("Browser");
    }

    public String getStringUrl(){
        return pro.getProperty("URL");
    }

}
