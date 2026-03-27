package cat.itacademy.s1_05.n1.ex3;

import cat.itacademy.s1_05.util.DirectoryTreeBuilder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DirectoryTreeWriter {

    public void writeDirectoryTree(String directoryPath, String outputPath) {
        writeDirectoryTree(directoryPath, outputPath, null);
    }

    public void writeDirectoryTree(String directoryPath, String outputPath, String footer) {
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.err.println("Directory does not exist: " + directoryPath);
            return;
        }
        if (!directory.isDirectory()) {
            System.err.println("Path is not a directory: " + directoryPath);
            return;
        }

        String content = DirectoryTreeBuilder.build(directory);
        if (footer != null) {
            content += footer;
        }

        writeToFile(new File(outputPath), content);
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
        if (args.length != 2) {
            System.err.println("Usage: java DirectoryTreeWriter <directory_path> <output_path>");
            return;
        }
        String directoryPath = System.getProperty("user.dir") + File.separator + args[0];
        String outputPath = System.getProperty("user.dir") + File.separator + args[1];
        new DirectoryTreeWriter().writeDirectoryTree(directoryPath, outputPath);
    }
}