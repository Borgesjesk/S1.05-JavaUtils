# S1.05 - Java Utils

## 📌 Exercise Description
Working with essential Java utilities for real-world software development: file and directory management, data reading and writing, flexible configuration, and basic object serialization.

## ✨ Functionalities

### Level 1 - Java I/O
- **Exercise 1:** List directory contents alphabetically
- **Exercise 2:** Recursive directory tree listing with type and last modified date
- **Exercise 3:** Save recursive directory tree to a TXT file
- **Exercise 4:** Read and display any TXT file contents to console
- **Exercise 5:** Serialize and deserialize Java objects to/from a `.ser` file

### Level 2 - Configuration
- **Exercise 1:** Parameterized directory tree export using a `.properties` config file

## 🛠 Technologies
- Java 21
- java.io, java.nio.file, java.util
- Java Properties API
- Maven 3.9.11

## 🚀 Compile and Run

### Compile
```bash
mvn compile
```

### Run each exercise
```bash
# N1 - Ex1: List directory alphabetically
mvn exec:java -Dexec.mainClass="cat.itacademy.s1_05.n1.ex1.DirectoryLister" -Dexec.args="src"

# N1 - Ex2: Recursive directory tree
mvn exec:java -Dexec.mainClass="cat.itacademy.s1_05.n1.ex2.DirectoryTreeLister" -Dexec.args="src"

# N1 - Ex3: Save tree to TXT
mvn exec:java -Dexec.mainClass="cat.itacademy.s1_05.n1.ex3.DirectoryTreeWriter" -Dexec.args="src output/tree.txt"

# N1 - Ex4: Read TXT file
mvn exec:java -Dexec.mainClass="cat.itacademy.s1_05.n1.ex4.TxtFileReader" -Dexec.args="output/tree.txt"

# N1 - Ex5: Serialize and deserialize
mvn exec:java -Dexec.mainClass="cat.itacademy.s1_05.n1.ex5.SerializationDemo" -Dexec.args="output"

# N2 - Ex1: Parameterized directory tree
mvn exec:java -Dexec.mainClass="cat.itacademy.s1_05.n2.DirectoryTreeConfig"
```

## 🚀 Installation
