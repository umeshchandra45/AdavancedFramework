package com.Forsys.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertyFile {

    static Properties prop = new Properties();

    public static String readPropertyFile(String strFilePath, String strKey) throws IOException {
        InputStream input = ReadPropertyFile.class.getResourceAsStream(strFilePath);
        Properties prop = new Properties();
        prop.load(input);
        return prop.getProperty(strKey);
    }

}
