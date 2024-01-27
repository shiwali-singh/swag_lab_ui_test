package com.task.automation.core;

import com.task.automation.enums.driverTypes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class configurationManager {
    public Properties properties;
    String propertyFile = "C:\\Users\\shiwa\\IdeaProjects\\swag_lab_ui_test\\resources\\configuration.properties.txt";

    public configurationManager() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFile));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("configuration.properties not found at " + propertyFile);
        }
    }

    public driverTypes getBrowser() {
        String browserName = properties.getProperty("browser");
        if (browserName.equals("chrome"))
            return driverTypes.CHROME;
        else if (browserName.equalsIgnoreCase("firefox"))
            return driverTypes.FIREFOX;
        else if (browserName.equals("iexplorer"))
            return driverTypes.INTERNETEXPLORER;
        else
            throw new RuntimeException(
                    "Please provide valid browser value from configuration.properties file:"+browserName);
    }

    public String getUrl(){
        String browserUrl = properties.getProperty("url");
        return browserUrl;
    }
}
