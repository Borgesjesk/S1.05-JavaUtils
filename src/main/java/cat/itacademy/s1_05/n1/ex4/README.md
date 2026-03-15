# N1 Exercise 4 - Read TXT File

## 📌 Exercise Description
Create a class that reads any TXT file and displays its contents to the console.

## ✨ Functionalities
- Accepts a file path as a command line argument
- Validates the file exists and is a .txt file
- Displays full file contents to console

## 🚀 Compile and Run
```bash
mvn compile
mvn exec:java -Dexec.mainClass="cat.itacademy.s1_05.n1.ex4.TxtFileReader" -Dexec.args="output/tree.txt"
```

## 🛠 Technologies
- Java 21
- java.nio.file, java.io.BufferedReader
- Maven