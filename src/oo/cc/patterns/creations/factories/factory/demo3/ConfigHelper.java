package oo.cc.patterns.creations.factories.factory.demo3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

/**
 * Created by laiis on 2018/9/19.
 */
public class ConfigHelper {

    public static volatile ConfigHelper sConfigHelper;

    public static ConfigHelper newInstance() {
        if (sConfigHelper == null) {
            synchronized (ConfigHelper.class) {
                if (sConfigHelper == null) {
                    sConfigHelper = new ConfigHelper();
                }
            }
        }

        return sConfigHelper;
    }

    public static void initial(String fileName) {
        try {
            Properties properties = new Properties();
            properties.load(new BufferedReader(new FileReader(fileName)));
            ConfigHelper.newInstance().setProperties(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Properties properties;

    private ConfigHelper() {

    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }


    public String getValue(String key) {
        return properties.getProperty(key);
    }
}
