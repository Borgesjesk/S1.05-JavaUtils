# N1 Exercise 3 - Save Directory Tree to TXT

## 📌 Exercise Description
Extends Exercise 2 to save the recursive directory tree to a TXT file instead of printing to console.

## ✨ Functionalities
- Accepts directory path and output file path as arguments
- Saves full recursive tree to a TXT file
- Sorts alphabetically within each level
- Shows type and last modified date

## 🚀 Compile and Run
```bash
mvn compile
mvn exec:java -Dexec.mainClass="cat.itacademy.s1_05.n1.ex3.DirectoryTreeWriter" -Dexec.args="src output/tree.txt"
```

## 🛠 Technologies
- Java 21
- java.io.File, java.io.BufferedWriter
- Maven