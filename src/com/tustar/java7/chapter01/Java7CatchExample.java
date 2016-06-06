package com.tustar.java7.chapter01;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

/**
 * Created by tustar on 7/30/15.
 */
public class Java7CatchExample {

    public static class Configuration {
    }

    public static class ConfigurationException extends Exception {
    }

    public Configuration getConfig(String fileName) {
        Configuration cfg = null;
        try {
            String fileText = getFile(fileName);
            cfg = verifyConfig(parseConfig(fileText));
        } catch (FileNotFoundException | ParseException | ConfigurationException e) {
            System.err.println("Config file '" + fileName
                    + "' is missing or malformed");
        } catch (IOException e) {
            System.err.println("Error while processing file '" + fileName + "'");
        }

        return cfg;
    }

    private Configuration verifyConfig(Configuration parseConfig)
            throws ConfigurationException {
        // This is just here to ensure code compiles
        return null;
    }

    // throws ParseException if file is malformed
    private Configuration parseConfig(String fileText) throws ParseException {
        // This is just here to ensure code compiles
        return null;
    }

    // Can throw a FileNotFoundException if file doesn't exist, or IOException if
    // something bad happens
    // while trying to read from it
    private String getFile(String fileName_) throws IOException {
        // This is just here to ensure code compiles
        return null;
    }
}
