package com.gilson.blogger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationProperties {

    private static Properties properties = new Properties();

    private static InputStream input;
    
    private ApplicationProperties() {
        // Private constructor
    }

    static {
        try {
            input = new FileInputStream("application.properties");

            properties.load(input);
        } catch (FileNotFoundException ex) {
            System.err.println("[ERROR] application.properties file not found!");
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getProperty(String property) {
        return properties.getProperty(property);
    }
}
