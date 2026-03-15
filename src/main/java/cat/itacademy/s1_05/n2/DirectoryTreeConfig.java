package cat.itacademy.s1_05.n2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Properties;

public class DirectoryTreeConfig {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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

        File directory = new File(fullInputPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.err.println("Invalid directory: " + fullInputPath);
            return;
        }

        StringBuilder content = new StringBuilder();
        content.append(" ─").append(directory.getName()).append("\n");
        buildTree(directory, 0, content);
        content.append("* Saved using config.properties");

        writeToFile(new File(fullOutputPath), content.toString());
    }

    private void buildTree(File directory, int depth, StringBuilder content) {
        File[] files = directory.listFiles();
        if (files == null || files.length == 0) return;

        Arrays.sort(files, (a, b) -> a.getName().compareToIgnoreCase(b.getName()));

        for (File file : files) {
            String indent = "\t".repeat(depth + 1);
            String type = file.isDirectory() ? "(D)" : "(F)";
            String lastModified = DATE_FORMAT.format(file.lastModified());
            content.append(indent).append("└").append(type).append(" ")
                    .append(file.getName()).append(" | ").append(lastModified).append("\n");

            if (file.isDirectory()) {
                buildTree(file, depth + 1, content);
            }
        }
    }

    private void writeToFile(File outputFile, String content) {
        outputFile.getParentFile().mkdirs();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(content);
            System.out.println("Tree saved to: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new DirectoryTreeConfig().run();
    }
}