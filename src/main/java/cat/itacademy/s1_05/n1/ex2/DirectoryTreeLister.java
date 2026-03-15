package cat.itacademy.s1_05.n1.ex2;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class DirectoryTreeLister {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void listDirectory(String path) {
        File directory = new File(path);

        if (!directory.exists()) {
            System.err.println("Directory does not exist: " + path);
            return;
        }
        if (!directory.isDirectory()) {
            System.err.println("Path is not a directory: " + path);
            return;
        }

        System.out.println(" ─" + directory.getName());
        listRecursively(directory, 0);
    }

    private void listRecursively(File directory, int depth) {
        File[] files = directory.listFiles();
        if (files == null || files.length == 0) return;

        Arrays.sort(files, (a, b) -> a.getName().compareToIgnoreCase(b.getName()));

        for (File file : files) {
            String indent = "\t".repeat(depth + 1);
            String type = file.isDirectory() ? "(D)" : "(F)";
            String lastModified = DATE_FORMAT.format(file.lastModified());
            System.out.println(indent + "└" + type + " " + file.getName() + " | " + lastModified);

            if (file.isDirectory()) {
                listRecursively(file, depth + 1);
            }
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: java DirectoryTreeLister <directory_path>");
            return;
        }
        String path = System.getProperty("user.dir") + File.separator + args[0];
        new DirectoryTreeLister().listDirectory(path);
    }
}