package com.conxillium.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {

    private Properties getData(String fileName) {
        // This is the loader of the class
        ClassLoader classLoader = getClass().getClassLoader();

        // This will look for a file name that is given as fileName in resource folder in the project and get it
        File file = new File(classLoader.getResource(fileName + ".properties").getFile());

        // Create a FileInputStream variable to place the given file and initiate as null
        FileInputStream fileInput = null;

        // Assigning the returned file to fileInput variable
        try {
            fileInput = new FileInputStream(file);
        }
        // If file not found or file is broken, this will print a stachTrace
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Creating a Property object to capture property details
        Properties prop = new Properties();

        // Loading property file and access data inside
        try {
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    public String getProperty(String fileName, String key) {
        return getData(fileName).getProperty(key);
    }
}