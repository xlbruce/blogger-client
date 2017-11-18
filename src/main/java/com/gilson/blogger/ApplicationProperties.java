package com.gilson.blogger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApplicationProperties {

    private static final Logger LOG = Logger.getLogger(ApplicationProperties.class.getName());
            
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
            LOG.severe("application.properties file not found!");
            System.exit(1);
        } catch (IOException e) {
            LOG.log(Level.SEVERE, "IOException occurred", e);
        }
        finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    LOG.log(Level.SEVERE, "IOException occurred", e);
                }
            }
        }
    }

    public static String getProperty(String property) {
        return properties.getProperty(property);
    }
}
