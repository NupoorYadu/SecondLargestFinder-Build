# Second Largest Finder - Maven Project

## Overview
This project demonstrates a Java program to find the second largest element in an array **without sorting**, implemented with O(n) time complexity and O(1) space complexity.

## Algorithm
The program uses a single-pass traversal strategy:
- Maintain two variables: `largest` and `secondLargest`
- For each element:
  - If it's greater than `largest`, update both (move `largest` to `secondLargest`)
  - Else if it's greater than `secondLargest` and not equal to `largest`, update `secondLargest`

**Complexity:**
- Time: O(n) - single pass
- Space: O(1) - only two variables

## Project Structure
```
Experiment1/
├── pom.xml                          # Maven configuration
├── Jenkinsfile                      # Jenkins Pipeline as Code
├── README.md                        # This file
├── JENKINS_SETUP.md                 # Jenkins configuration guide
├── .gitignore                       # Git ignore file
└── src/
    ├── main/java/com/example/
    │   └── SecondLargestFinder.java  # Main algorithm implementation
    └── test/java/com/example/
        └── SecondLargestFinderTest.java  # JUnit tests
```

## Building Locally

### Prerequisites
- Java JDK 11 or higher
- Maven 3.8.1 or higher
- Git

### Build Steps
```bash
# Clone the repository
git clone <repository-url>
cd Experiment1

# Clean and compile
mvn clean compile

# Run tests
mvn test

# Package JAR
mvn package

# Run the main program
java -jar target/second-largest-finder-1.0.0.jar
```

## Running the Application

### Via Maven
```bash
mvn exec:java -Dexec.mainClass="com.example.SecondLargestFinder"
```

### Via JAR
```bash
java -jar target/second-largest-finder-1.0.0.jar
```

## Testing
The project includes comprehensive unit tests using JUnit 5 covering:
- Normal arrays
- Simple two-element arrays
- Arrays with duplicates
- Arrays with negative numbers
- Mixed positive and negative numbers
- Error cases (null, single element, all identical)

Run tests with:
```bash
mvn test
```

## Jenkins Automation

### Prerequisites
- Jenkins server running
- Maven plugin installed
- Git plugin installed
- Email notification plugin (optional)

### Quick Setup
1. Create a new Pipeline job in Jenkins
2. Point it to this repository's Jenkinsfile
3. Configure build triggers (polling or webhook)
4. Run the build

For detailed Jenkins setup instructions, see [JENKINS_SETUP.md](JENKINS_SETUP.md)

## Pipeline Stages
The Jenkinsfile includes the following stages:
1. **Checkout** - Clone the Git repository
2. **Build** - Compile the source code
3. **Test** - Run unit tests
4. **Package** - Create JAR artifact
5. **Archive Artifacts** - Store build outputs

## Example Output
```
Array: [12, 35, 1, 10, 34, 1, 45, 23]
Second Largest Element: 34

Array: [100, 50, 75, 25, 90]
Second Largest Element: 90

Array: [-5, -10, -1, -20]
Second Largest Element: -5
```

## Author
Algorithm Demonstration Project

## License
MIT License
