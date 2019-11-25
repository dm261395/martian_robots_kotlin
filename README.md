# Martian Robots

This project was implemented in Kotlin v1.3.60 and uses Maven Wrapper for building. ANTLR4 is used to parse the input
according to the grammar defined in `src/main/antlr4`. `JUnit4` is used for testing.

## Build

```console
./mvnw clean package
```

## Run

Input is read from `input.txt`.

```console
java -jar target/martian-robots-1.0-SNAPSHOT-jar-with-dependencies.jar
```
