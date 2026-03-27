package cat.itacademy.s1_05.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class DirectoryTreeBuilder {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String build(File directory) {
        StringBuilder content = new StringBuilder();
        content.append(" ─").append(directory.getName()).append("\n");
        buildTree(directory, 0, content);
        return content.toString();
    }

    private static void buildTree(File directory, int depth, StringBuilder content) {
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
}
