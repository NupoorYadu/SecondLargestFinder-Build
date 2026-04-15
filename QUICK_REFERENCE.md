# Quick Reference Guide

## One-Line Build Commands

### Local Development
```bash
# Build and run tests
mvn clean install

# Run just the application
mvn exec:java -Dexec.mainClass="com.example.SecondLargestFinder"

# Run tests only
mvn test

# Create JAR
mvn package

# Run JAR
java -jar target/second-largest-finder-1.0.0.jar
```

### Jenkins Automated Build
```
CI/CD Pipeline automatically:
Checkout → Compile → Test → Package → Archive
```

---

## Project Structure

```
Experiment1/
├── pom.xml                           # Maven configuration
├── Jenkinsfile                       # Jenkins Pipeline (Groovy)
├── jenkins-job-config.xml            # Jenkins job configuration
├── README.md                         # Project overview
├── JENKINS_SETUP.md                  # Jenkins setup guide
├── JENKINS_JOB_CONFIGURATION.md     # Job config demonstration
├── QUICK_REFERENCE.md               # This file
├── BUILD_OUTPUT_EXAMPLE.txt         # Example build output
├── .gitignore                       # Git ignore rules
│
└── src/
    ├── main/java/com/example/
    │   └── SecondLargestFinder.java
    │       • Algorithm implementation
    │       • O(n) time, O(1) space
    │       • Single-pass traversal
    │       • Main method for demo
    │
    └── test/java/com/example/
        └── SecondLargestFinderTest.java
            • JUnit 5 tests
            • 8 comprehensive test cases
            • Edge cases covered
```

---

## Key Algorithm Features

| Feature | Detail |
|---------|--------|
| **Time Complexity** | O(n) - Single pass |
| **Space Complexity** | O(1) - Only two variables |
| **Approach** | Greedy algorithm |
| **Key Variables** | `largest`, `secondLargest` |
| **Edge Cases Handled** | Duplicates, negatives, null input |

---

## Maven Build Lifecycle

```
clean       → Remove target/ directory
compile     → Compile source to target/classes/
test        → Run unit tests
package     → Create JAR in target/
install     → Install JAR to local repository
deploy      → Upload to remote repository
```

### Common Maven Commands

```bash
mvn clean              # Clean build artifacts
mvn compile            # Compile only
mvn test               # Run tests
mvn package            # Create JAR
mvn clean package      # Clean and package
mvn clean install      # Clean, package, and install locally
```

---

## JUnit Test Coverage

### Test Cases (8 total)

1. **Normal Array**: `[12, 35, 1, 10, 34, 1, 45, 23]` → 34
2. **Simple Array**: `[1, 2]` → 1
3. **With Duplicates**: `[5, 5, 3, 2, 1]` → 3
4. **Negative Numbers**: `[-5, -10, -1, -20]` → -5
5. **Mixed Numbers**: `[100, -50, 75, 25, 90]` → 90
6. **Null Array**: Throws `IllegalArgumentException`
7. **Single Element**: Throws `IllegalArgumentException`
8. **All Identical**: Throws `IllegalArgumentException`

---

## Jenkins Pipeline Stages

```
1. Checkout   [Git Clone]
   └─ Logs last 5 commits

2. Build      [Maven Compile]
   └─ mvn clean compile

3. Test       [JUnit Execution]
   └─ mvn test
   └─ Generates: target/surefire-reports/

4. Package    [JAR Creation]
   └─ mvn package -DskipTests
   └─ Creates: target/second-largest-finder-1.0.0.jar

5. Archive    [Store Artifacts]
   └─ Stores JAR in Jenkins workspace
```

---

## Build Triggers

### Option 1: Poll SCM
- **Schedule**: `H/15 * * * *` (every 15 minutes)
- **Type**: Pull-based
- **Latency**: ~15 minutes

### Option 2: GitHub Webhook
- **Type**: Push-based
- **Latency**: Immediate (< 1 second)
- **Setup**: Requires GitHub plugin + webhook

---

## Environment Variables in Jenkins

```groovy
${BUILD_NUMBER}    // Current build number
${JOB_NAME}        // Job name
${WORKSPACE}       // Build directory
${BUILD_URL}       // Jenkins build URL
${GIT_BRANCH}      // Current branch
${GIT_COMMIT}      // Commit SHA
${BUILD_TIMESTAMP} // Build time
```

---

## Artifact Locations

### After Build
```
Jenkins Workspace: /var/jenkins/workspace/SecondLargestFinder-Build/
├── target/
│   ├── second-largest-finder-1.0.0.jar      ✓ Artifact
│   ├── surefire-reports/
│   │   ├── TEST-*.xml                       ✓ Test results
│   │   └── index.html
│   ├── classes/
│   │   └── com/example/*.class
│   └── ...
└── ...
```

### After Archive
```
Jenkins: http://jenkins:8080/job/name/builds/123/artifact/
Download: target/second-largest-finder-1.0.0.jar
```

---

## Email Notifications

### On Success
```
To: Developer + Requestor
Subject: Build SUCCESS: second-largest-finder #123
Body: Build completed successfully
      Artifacts available at: http://jenkins:8080/.../artifact/
```

### On Failure
```
To: Developers + Broken Build Suspects + Requestor
Subject: Build FAILED: second-largest-finder #123
Body: Build failed
      Check console: http://jenkins:8080/.../console
```

---

## Git Workflow

```bash
# 1. Clone repository
git clone <repo-url>
cd Experiment1

# 2. Create feature branch
git checkout -b feature/enhancement

# 3. Make changes + commit
git add .
git commit -m "Add new feature"

# 4. Push to remote
git push origin feature/enhancement

# 5. Create Pull Request
# GitHub UI: Create PR from feature/enhancement → main

# 6. Jenkins builds automatically (webhook)
# Tests run, coverage checked

# 7. Merge to main when approved
git checkout main
git merge feature/enhancement
git push origin main

# 8. Jenkins tags release
# Artifact published
```

---

## Troubleshooting Checklist

- [ ] Git repo URL correct
- [ ] GitHub credentials configured
- [ ] Maven installed on Jenkins
- [ ] JDK 11+ available
- [ ] Tests passing locally
- [ ] pom.xml valid XML
- [ ] Jenkinsfile syntax correct
- [ ] Build artifacts exist

---

## Performance Metrics

### Typical Build Times
- **Checkout**: 10-20 seconds
- **Compile**: 20-40 seconds
- **Test**: 30-60 seconds
- **Package**: 10-20 seconds
- **Archive**: 5 seconds

**Total**: ~2-3 minutes for full pipeline

---

## Download Artifacts

### From Jenkins UI
```
Build Page → Artifacts → Download second-largest-finder-1.0.0.jar
```

### From Command Line
```bash
wget http://jenkins:8080/job/name/lastSuccessfulBuild/artifact/target/second-largest-finder-1.0.0.jar
```

### Direct Execution
```bash
java -jar second-largest-finder-1.0.0.jar
```

---

## Useful Jenkins URLs

| Page | URL |
|------|-----|
| Home | http://localhost:8080/ |
| Job | http://localhost:8080/job/SecondLargestFinder-Build/ |
| Build | http://localhost:8080/job/name/123/ |
| Console | http://localhost:8080/job/name/123/console |
| Artifacts | http://localhost:8080/job/name/123/artifact/ |
| Pipeline Syntax | http://localhost:8080/job/name/pipeline-syntax/ |

---

## Support Resources

- **Jenkins Docs**: https://jenkins.io/doc/
- **Maven Guide**: https://maven.apache.org/guides/
- **Git Basics**: https://git-scm.com/book/en/v2
- **JUnit 5**: https://junit.org/junit5/docs/current/user-guide/

---

**Last Updated**: 2026-04-16
