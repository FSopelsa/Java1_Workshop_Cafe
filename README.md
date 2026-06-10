# Current commands:

### Build the project (compile):
```bash
mvn -DskipTests package
```

### Run tests:
```bash
mvn test
```

### Run the application from the compiled classes (no jar packaging needed):
```bash
java -cp target\classes se.lexicon.Main
```