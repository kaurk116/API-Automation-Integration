package com.thetestingacademy.utils;

import java.io.FileInputStream;
import java.util.Properties;

//open that FileInputStream
//Understand the workbook
//sheet
//Row
//Column
//Cell
//Close the Stream

public class PropertyReader {

    public static String readKey(String key) {

        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/Resources/Data.Properties");
            properties.load(fileInputStream);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return properties.getProperty(key);
    }


}

