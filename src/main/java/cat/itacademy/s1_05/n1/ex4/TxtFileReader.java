package cat.itacademy.s1_05.n1.ex4;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TxtFileReader {

    public void readFile(String path) {
        Path filePath = Paths.get(path);

        if (!Files.exists(filePath)) {
            System.err.println("File does not exist: " + path);
            return;
        }
        if (!Files.isRegularFile(filePath)) {
            System.err.println("Path is not a file: " + path);
            return;
        }
        if (!path.endsWith(".txt")) {
            System.err.println("File is not a TXT file: " + path);
            return;
        }

        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            System.out.println("Contents of: " + filePath.toAbsolutePath());
            System.out.println("─".repeat(40));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("─".repeat(40));
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: java TxtFileReader <file_path>");
            return;
        }
        String path = System.getProperty("user.dir") + File.separator + args[0];
        new TxtFileReader().readFile(path);
    }
}