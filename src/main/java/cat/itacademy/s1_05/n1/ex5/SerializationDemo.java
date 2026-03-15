package cat.itacademy.s1_05.n1.ex5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationDemo {

    public void serialize(File outputFile, Person[] persons) {
        if (!outputFile.getParentFile().mkdirs() && !outputFile.getParentFile().exists()) {
            System.err.println("Could not create output directory.");
            return;
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFile))) {
            oos.writeObject(persons);
            System.out.println("Serialized " + persons.length + " person(s) to: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error serializing object: " + e.getMessage());
        }
    }

    public void deserialize(File inputFile) {
        if (!inputFile.exists()) {
            System.err.println("Serialized file not found: " + inputFile.getAbsolutePath());
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFile))) {
            Person[] persons = (Person[]) ois.readObject();
            System.out.println("Deserialized " + persons.length + " person(s):");
            for (Person person : persons) {
                System.out.println("  " + person);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error deserializing object: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java SerializationDemo <output_directory>");
            return;
        }

        String filePath = System.getProperty("user.dir") + File.separator + args[0] + File.separator + "persons.ser";
        File outputFile = new File(filePath);

        Person[] persons = {
                new Person("Jessica", 30, "jessica@example.com"),
                new Person("Emily", 28, "emily@example.com"),
                new Person("Maria", 40, "maria@example.com")
        };

        SerializationDemo demo = new SerializationDemo();
        demo.serialize(outputFile, persons);
        demo.deserialize(outputFile);
    }
}