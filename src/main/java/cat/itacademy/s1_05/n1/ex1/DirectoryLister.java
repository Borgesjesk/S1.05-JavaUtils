package cat.itacademy.s1_05.n1.ex1;

import java.io.File;
import java.util.Arrays;

public class DirectoryLister {

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

        File[] files = directory.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("Directory is empty.");
            return;
        }

        Arrays.sort(files, (a, b) -> a.getName().compareToIgnoreCase(b.getName()));

        System.out.println(" ─" + directory.getName());
        for (File file : files) {
            System.out.println("\t└ " + file.getName());
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: java DirectoryLister <directory_path>");
            return;
        }
        String path = System.getProperty("user.dir") + File.separator + args[0];
        new DirectoryLister().listDirectory(path);
    }
}