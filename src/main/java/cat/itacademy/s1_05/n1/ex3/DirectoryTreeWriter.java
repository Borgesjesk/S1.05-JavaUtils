package cat.itacademy.s1_05.n1.ex3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class DirectoryTreeWriter {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void writeDirectoryTree(String directoryPath, String outputPath) {
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.err.println("Directory does not exist: " + directoryPath);
            return;
        }
        if (!directory.isDirectory()) {
            System.err.println("Path is not a directory: " + directoryPath);
            return;
        }

        StringBuilder content = new StringBuilder();
        content.append(" ─").append(directory.getName()).append("\n");
        buildTree(directory, 0, content);

        writeToFile(new File(outputPath), content.toString());
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
        if (args.length != 2) {
            System.err.println("Usage: java DirectoryTreeWriter <directory_path> <output_path>");
            return;
        }
        String directoryPath = System.getProperty("user.dir") + File.separator + args[0];
        String outputPath = System.getProperty("user.dir") + File.separator + args[1];
        new DirectoryTreeWriter().writeDirectoryTree(directoryPath, outputPath);
    }
}