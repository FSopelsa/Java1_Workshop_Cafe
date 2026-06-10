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

### Using the project wrapper (recommended)
If you want to run Maven without installing it globally, use the provided wrapper scripts.

On Windows (PowerShell or cmd):
```powershell
.\\mvnw.cmd test
```

On macOS / Linux:
```bash
./mvnw test
```

---------------------------------------
## How the wrapper scripts work:

- First they check whether mvn is already on PATH; if yes they just call the system mvn with the same arguments.
- If mvn is not found, they download the Maven binary distribution (currently pinned to 3.9.16 from the Apache archive) into .mvn/wrapper/, extract it and run the mvn binary from there.
- This approach does not require including the official maven-wrapper.jar — instead the scripts perform the download+extract step themselves. It achieves the practical goal of allowing .\mvnw.cmd test on a machine without a prior Maven install.

### How to use the wrapper locally:
- On Windows (PowerShell or cmd): .\mvnw.cmd test
- On macOS / Linux: chmod +x ./mvnw ./mvnw test

### What to expect on first run
- If mvn is not installed, the script will:
    - download the Maven zip/tarball from Apache archive,
    - extract it under .mvn/wrapper/apache-maven-<version>,
    - then run the downloaded Maven binary.
- Subsequent runs will reuse the downloaded Maven in .mvn/apache-maven-<version>.