# N1 Exercise 5 - Serialization and Deserialization

## 📌 Exercise Description
Serialize an array of Java objects to a .ser file and deserialize them back.

## ✨ Functionalities
- Serializes an array of Person objects to a .ser file
- Deserializes and prints the objects back to console
- Accepts output directory as a command line argument
- Validates age cannot be negative

## 🚀 Compile and Run
```bash
mvn compile
mvn exec:java -Dexec.mainClass="cat.itacademy.s1_05.n1.ex5.SerializationDemo" -Dexec.args="output"
```

## 🛠 Technologies
- Java 21
- java.io.Serializable, ObjectOutputStream, ObjectInputStream
- Maven