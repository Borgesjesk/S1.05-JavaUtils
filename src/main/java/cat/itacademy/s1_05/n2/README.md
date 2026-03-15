# N2 Exercise 1 - Parameterized Configuration

## 📌 Exercise Description
Extends N1 Exercise 3 to read the input directory and output file path from a .properties config file instead of command line arguments.

## ✨ Functionalities
- Reads configuration from `config.properties` in classpath
- Configurable input directory and output file path
- Saves recursive directory tree to TXT with alphabetical sorting
- Shows type and last modified date for each entry
- Adds footer note confirming config file was used

## ⚙️ Configuration
Edit `src/main/resources/config.properties`:
```properties
directory.input=src
output.file=output/directory_tree.txt
```

## 🚀 Compile and Run
```bash
mvn compile
mvn exec:java -Dexec.mainClass="cat.itacademy.s1_05.n2.DirectoryTreeConfig"
```

## 🛠 Technologies
- Java 21
- java.util.Properties
- java.io.BufferedWriter
- Maven
