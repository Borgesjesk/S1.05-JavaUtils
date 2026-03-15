# N1 Exercise 2 - Recursive Directory Tree

## 📌 Exercise Description
Extends Exercise 1 to recursively list all levels of a directory tree, indicating type (D/F) and last modified date.

## ✨ Functionalities
- Recursively lists all files and subdirectories
- Sorts alphabetically within each level
- Shows type: (D) for directory, (F) for file
- Shows last modified date for each entry

## 🚀 Compile and Run
```bash
mvn compile
mvn exec:java -Dexec.mainClass="cat.itacademy.s1_05.n1.ex2.DirectoryTreeLister" -Dexec.args="src"
```

## 🛠 Technologies
- Java 21
- java.io.File
- Maven