# Martian Robots

This project was implemented in Kotlin 1.3.60. Use Java 8 to run the packaged jar. 
ANTLR4 is used to parse the input according to the grammar defined in `src/main/antlr4`. `JUnit4` is used for testing.

## Build

```console
./mvnw clean package
```

## Run

Input is read from `input.txt`.

```console
java -jar target/martian-robots-1.0-SNAPSHOT-jar-with-dependencies.jar
```
