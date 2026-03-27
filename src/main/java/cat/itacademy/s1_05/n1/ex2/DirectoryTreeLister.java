package cat.itacademy.s1_05.n1.ex2;

import cat.itacademy.s1_05.util.DirectoryTreeBuilder;

import java.io.File;

public class DirectoryTreeLister {

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

        System.out.print(DirectoryTreeBuilder.build(directory));
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