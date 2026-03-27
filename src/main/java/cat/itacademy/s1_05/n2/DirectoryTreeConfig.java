package cat.itacademy.s1_05.n2;

import cat.itacademy.s1_05.n1.ex3.DirectoryTreeWriter;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DirectoryTreeConfig {

    private static final String CONFIG_FILE = "config.properties";

    private String loadProperty(String key) {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (input == null) {
                System.err.println("Config file not found: " + CONFIG_FILE);
                return null;
            }
            properties.load(input);
            return properties.getProperty(key);
        } catch (IOException e) {
            System.err.println("Error loading config: " + e.getMessage());
            return null;
        }
    }

    public void run() {
        String inputDir = loadProperty("directory.input");
        String outputPath = loadProperty("output.file");

        if (inputDir == null || outputPath == null) {
            System.err.println("Missing required properties in config file.");
            return;
        }

        String fullInputPath = System.getProperty("user.dir") + File.separator + inputDir;
        String fullOutputPath = System.getProperty("user.dir") + File.separator + outputPath;

        new DirectoryTreeWriter().writeDirectoryTree(fullInputPath, fullOutputPath, "* Saved using config.properties");
    }

    public static void main(String[] args) {
        new DirectoryTreeConfig().run();
    }
}