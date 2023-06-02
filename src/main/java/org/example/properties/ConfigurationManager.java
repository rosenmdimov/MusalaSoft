package org.example.properties;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.Utils.PropertiesFileNotFoundException;

import java.io.*;
import java.util.Properties;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ConfigurationManager {
    private static final String PATH_TO_PROPERTIES = "src/main/resources/";
    public static final String PATH_TO_COMMON_PROPS = PATH_TO_PROPERTIES + "common.properties";


    public static String getProperties(String propKey) {
        Properties prop = new Properties();
        try (InputStream input = new FileInputStream(PATH_TO_COMMON_PROPS)) {
            prop.load(input);
        } catch (IOException ex) {
            throw new PropertiesFileNotFoundException(PATH_TO_COMMON_PROPS, ex);
        }
        return prop.getProperty(propKey);
    }

}
