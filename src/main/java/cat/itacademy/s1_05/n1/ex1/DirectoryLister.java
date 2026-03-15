package cat.itacademy.s1_05.n1.ex1;

import java.io.File;
import java.util.Arrays;

public class DirectoryLister {

    public void listDirectory(String path) {
        File directory = new File(path);

        if (!directory.exists()) {
            System.out.println("Directory does not exist: " + path);
            return;
        }
        if (!directory.isDirectory()) {
            System.out.println("Path is not a directory: " + path);
            return;
        }

        File[] files = directory.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("Directory is empty.");
            return;
        }

        Arrays.sort(files, (a, b) -> a.getName().compareToIgnoreCase(b.getName()));

        System.out.println("Contents of: " + directory.getAbsolutePath());
        for (File file : files) {
            System.out.println(file.getName());
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java DirectoryLister <directory_path>");
            return;
        }
        new DirectoryLister().listDirectory(args[0]);
    }
}