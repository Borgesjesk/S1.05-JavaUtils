# N1 Exercise 1 - List Directory Alphabetically

## 📌 Exercise Description
Create a class that lists the contents of a directory received as a parameter, sorted alphabetically.

## ✨ Functionalities
- Receives a directory path as a command line argument
- Validates that the path exists and is a directory
- Lists all contents alphabetically (case insensitive)

## 🚀 Compile and Run
```bash
mvn compile
mvn exec:java -Dexec.mainClass="cat.itacademy.s1_05.n1.ex1.DirectoryLister" -Dexec.args="src"
```

## 🛠 Technologies
- Java 21
- java.io.File
- Maven