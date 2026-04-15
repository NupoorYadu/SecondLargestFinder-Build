# Second Largest Finder - Maven Project with Jenkins CI/CD

## 📋 Quick Overview
This project demonstrates a **Maven-based Java application** integrated with **Jenkins CI/CD automation** that finds the second largest element in an array **without sorting**. 

**Key Features:**
- ✅ O(n) time complexity, O(1) space complexity
- ✅ 8 comprehensive JUnit 5 tests
- ✅ Complete Jenkins Pipeline automation
- ✅ Git integration with GitHub
- ✅ Windows & Linux compatible

---

## 🎯 Algorithm

**Problem:** Find the second largest element in an array without sorting

**Solution:** Single-pass greedy algorithm
```
1. Initialize: largest = MIN_VALUE, secondLargest = MIN_VALUE
2. For each element in array:
   - If element > largest:
     - secondLargest = largest
     - largest = element
   - Else if element > secondLargest AND element != largest:
     - secondLargest = element
3. Return secondLargest
```

**Complexity:**
- **Time:** O(n) - single pass through array
- **Space:** O(1) - only two variables
- **Handles:** Duplicates, negative numbers, edge cases

---

## 📁 Project Structure

```
Experiment1/
├── Documentation
│   ├── README.md                      ← You are here
│   ├── QUICK_REFERENCE.md             ← Command cheatsheet
│   ├── JENKINS_SETUP.md               ← Jenkins setup guide
│   ├── JENKINS_JOB_CONFIGURATION.md   ← Detailed job config
│   └── BUILD_OUTPUT_EXAMPLE.md        ← Sample build output
│
├── Configuration Files
│   ├── pom.xml                        ← Maven configuration
│   ├── Jenkinsfile                    ← Jenkins Pipeline (6 stages)
│   ├── jenkins-job-config.xml         ← Jenkins job XML config
│   └── .gitignore                     ← Git ignore rules
│
└── Source Code
    └── src/
        ├── main/java/com/example/
        │   └── SecondLargestFinder.java      (Impl: 41 lines)
        └── test/java/com/example/
            └── SecondLargestFinderTest.java  (Tests: 65 lines, 8 cases)
```

---

## 🚀 Getting Started

### Prerequisites
```bash
# Check Java (11+ required)
java -version

# Check Maven (3.8.1+ required)
mvn --version

# Check Git
git --version
```

### Option A: Clone from GitHub
```bash
git clone https://github.com/NupoorYadu/SecondLargestFinder-Build.git
cd SecondLargestFinder-Build
```

### Option B: Start Fresh
```bash
mkdir SecondLargestFinder-Build
cd SecondLargestFinder-Build
git init
```

---

## 📊 Maven Commands

### Basic Build Commands
```bash
# Compile only (fast)
mvn clean compile

# Compile + Run tests
mvn clean test

# Full build (compile + test + package)
mvn clean install

# Package without running tests
mvn package -DskipTests

# Clean build artifacts
mvn clean

# Show Maven version
mvn --version
```

### Advanced Maven Commands
```bash
# Run specific test class
mvn test -Dtest=SecondLargestFinderTest

# Skip integration tests
mvn clean install -DskipITs

# Skip tests entirely
mvn clean install -DskipTests

# View dependency tree
mvn dependency:tree

# Update dependencies
mvn versions:display-dependency-updates
```

### Run Application
```bash
# Via Maven exec plugin
mvn exec:java -Dexec.mainClass="com.example.SecondLargestFinder"

# Via compiled JAR
java -jar target/second-largest-finder-1.0.0.jar

# Just compile & run
mvn clean compile exec:java -Dexec.mainClass="com.example.SecondLargestFinder"
```

---

## 📝 Git Commands

### Initial Setup
```bash
# Initialize repository
git init

# Configure user (first time)
git config user.name "Your Name"
git config user.email "your.email@example.com"

# Configure globally (all repos)
git config --global user.name "Your Name"
git config --global user.email "your.email@example.com"
```

### Committing Changes
```bash
# Add all files
git add .

# Add specific file
git add Jenkinsfile

# Commit changes
git commit -m "Description of changes"

# Amend last commit
git commit --amend

# View commit history
git log --oneline -5

# Show changes since last commit
git status
```

### Working with Remote (GitHub)

#### Add Remote Repository
```bash
# Add GitHub as origin
git remote add origin https://github.com/NupoorYadu/SecondLargestFinder-Build.git

# List all remotes
git remote -v

# Remove remote
git remote remove origin
```

#### Push to GitHub
```bash
# Rename branch to main (if needed)
git branch -M main

# Push to GitHub
git push -u origin main

# Push all commits
git push origin main

# Force push (use carefully!)
git push -f origin main
```

#### Pull from GitHub
```bash
# Fetch updates
git fetch origin

# Merge updates
git merge origin/main

# Pull (fetch + merge)
git pull origin main
```

#### Branching
```bash
# List local branches
git branch

# List all branches (local + remote)
git branch -a

# Create new branch
git checkout -b feature/new-feature

# Switch to branch
git checkout main

# Delete branch
git branch -d feature/new-feature
```

---

## 🧪 Testing Commands

### Run All Tests
```bash
# Run all tests with details
mvn test

# Run tests with verbose output
mvn test -X

# Run tests and generate report
mvn test-compile
```

### Run Specific Tests
```bash
# Run specific test class
mvn test -Dtest=SecondLargestFinderTest

# Run specific test method
mvn test -Dtest=SecondLargestFinderTest#testNormalArray

# Run multiple test classes
mvn test -Dtest=TestClass1,TestClass2
```

### View Test Results
```bash
# Test results location
target/surefire-reports/

# View XML results
target/surefire-reports/TEST-com.example.SecondLargestFinderTest.xml

# View HTML report (if generated)
target/site/surefire-report.html
```

---

## 🔧 Jenkins Commands

### Jenkins Setup (One-time)

#### Option 1: Using Docker (Easiest)
```bash
# Pull Jenkins image
docker pull jenkins/jenkins:latest

# Run Jenkins container
docker run -d -p 8080:8080 -p 50000:50000 jenkins/jenkins:latest

# Get initial admin password
docker logs <container-id>

# Access Jenkins
# Go to: http://localhost:8080
```

#### Option 2: Manual Installation
```bash
# Download Jenkins WAR
wget https://mirrors.jenkins.io/war-stable/latest/jenkins.war

# Run Jenkins
java -jar jenkins.war --port=8080

# Access Jenkins at http://localhost:8080
```

### Jenkins Job Configuration

#### Via Jenkins CLI
```bash
# Download Jenkins CLI
wget http://localhost:8080/download/war/jenkins.war/jnlpJars/jenkins-cli.jar

# Create job from XML config
java -jar jenkins-cli.jar -s http://localhost:8080 \
  create-job SecondLargestFinder-Build < jenkins-job-config.xml

# Build job via CLI
java -jar jenkins-cli.jar -s http://localhost:8080 \
  build SecondLargestFinder-Build

# Get job status
java -jar jenkins-cli.jar -s http://localhost:8080 \
  get-job SecondLargestFinder-Build
```

#### Via Jenkins UI
```
1. Open: http://localhost:8080
2. Click: New Item
3. Name: SecondLargestFinder-Build
4. Type: Pipeline
5. Configure:
   - Repository: https://github.com/NupoorYadu/SecondLargestFinder-Build.git
   - Branch: */main
   - Script Path: Jenkinsfile
6. Click: Save
7. Click: Build Now
```

### View Jenkins Builds
```
Console Output: http://localhost:8080/job/name/build#/console
Build Artifacts: http://localhost:8080/job/name/build#/artifact
Test Results: http://localhost:8080/job/name/build#/testReport
```

---

## 📦 Jenkins Pipeline Stages

The **Jenkinsfile** defines a 6-stage pipeline:

```
┌─────────────────────────────────────────┐
│           Jenkins Pipeline              │
└─────────────────────────────────────────┘
         ↓
┌─ STAGE 1: Checkout ────────────────────┐
│ • Clone from GitHub                    │
│ • Show git log                         │
└────────────────────────────────────────┘
         ↓
┌─ STAGE 2: Build ──────────────────────┐
│ • mvn clean compile                    │
│ • Compile source code                 │
└────────────────────────────────────────┘
         ↓
┌─ STAGE 3: Test ──────────────────────┐
│ • mvn test                             │
│ • Run 8 JUnit tests                   │
│ • All tests must pass                 │
└────────────────────────────────────────┘
         ↓
┌─ STAGE 4: Package ────────────────────┐
│ • mvn package -DskipTests             │
│ • Create JAR artifact                 │
└────────────────────────────────────────┘
         ↓
┌─ STAGE 5: Demo - Run Application ────┐
│ • java -jar second-largest-finder.jar │
│ • SHOWS OUTPUT:                       │
│   Second Largest Element: 35, 90, -5  │
└────────────────────────────────────────┘
         ↓
┌─ STAGE 6: Archive Artifacts ─────────┐
│ • Store JAR in Jenkins                │
│ • Accessible for download             │
└────────────────────────────────────────┘
         ↓
    ✓ BUILD SUCCESS
```

### Running Pipeline
```bash
# Automatically triggered every 15 minutes (polling)
# Or manually: Click "Build Now" in Jenkins UI
# Or via webhook: Git push triggers build
```

---

## 🎯 Complete Workflow Example

### Step 1: Set Up Locally
```bash
cd c:\Win_Sem_2025_26\ADDA\FAT\Experiment1
mvn clean install
java -jar target/second-largest-finder-1.0.0.jar
```

### Step 2: Initialize Git
```bash
git init
git config user.name "Developer"
git config user.email "dev@example.com"
git add .
git commit -m "Initial commit: Maven project with algorithm"
```

### Step 3: Push to GitHub
```bash
git remote add origin https://github.com/NupoorYadu/SecondLargestFinder-Build.git
git branch -M main
git push -u origin main
```

### Step 4: Configure Jenkins
```
1. Jenkins UI → New Item
2. Name: SecondLargestFinder-Build
3. Type: Pipeline
4. Repository: https://github.com/NupoorYadu/SecondLargestFinder-Build.git
5. Branch: */main
6. Script Path: Jenkinsfile
7. Build Triggers: Poll SCM (H/15 * * * *)
8. Save & Build Now
```

### Step 5: Make Changes (Later)
```bash
# Make code changes
# Commit
git add .
git commit -m "Fix: Update algorithm"
git push origin main

# Jenkins automatically builds on git push!
# Monitor at: http://localhost:8080/job/SecondLargestFinder-Build/
```

---

## 📊 Test Cases

The project includes **8 comprehensive test cases**:

| Test Case | Input | Expected Output | Status |
|-----------|-------|-----------------|--------|
| testNormalArray | [12, 35, 1, 10, 34, 1, 45, 23] | 35 | ✅ Pass |
| testSimpleArray | [1, 2] | 1 | ✅ Pass |
| testArrayWithDuplicates | [5, 5, 3, 2, 1] | 3 | ✅ Pass |
| testNegativeNumbers | [-5, -10, -1, -20] | -5 | ✅ Pass |
| testMixedNumbers | [100, -50, 75, 25, 90] | 90 | ✅ Pass |
| testNullArray | null | IllegalArgumentException | ✅ Pass |
| testSingleElement | [5] | IllegalArgumentException | ✅ Pass |
| testIdenticalElements | [5, 5, 5, 5] | IllegalArgumentException | ✅ Pass |

**Run tests:**
```bash
mvn test
```

**Expected output:**
```
Tests run: 8, Failures: 0, Errors: 0, Skipped: 0

BUILD SUCCESS
```

---

## 💾 Build Artifacts

After successful build, find artifacts at:

```
Local: target/second-largest-finder-1.0.0.jar
Jenkins: http://localhost:8080/job/name/build#/artifact
Maven Repo: C:\Users\<username>\.m2\repository\com\example\second-largest-finder\1.0.0\
```

**Run artifact:**
```bash
java -jar target/second-largest-finder-1.0.0.jar
```

---

## 📋 Pipeline Stages
---

## 🐛 Troubleshooting

### Build Issues

| Error | Cause | Solution |
|-------|-------|----------|
| `Maven command not found` | Maven not installed | Install Maven from apache.org |
| `Java command not found` | JDK not in PATH | Install JDK 11+ and set JAVA_HOME |
| `Cannot find jenkinsfile` | Wrong branch/path | Verify Script Path and Branch in Jenkins |
| `Git command not found` | Git not installed | Install Git for Windows |
| `Cannot run program "sh"` | Using Unix shell on Windows | Use `bat` instead of `sh` in Jenkinsfile |

### Git Issues
```bash
# Error: Detached HEAD state
git checkout main

# Error: Local changes would be overwritten
git stash
git pull origin main

# Error: Permission denied
# Check SSH keys or use HTTPS URL instead

# Remove cached files
git rm -r --cached .
git add .
git commit -m "Fix: Remove cached files"
```

### Jenkins Issues
```bash
# Restart Jenkins
http://localhost:8080/restart

# Check Jenkins logs
# Docker: docker logs <container-id>
# Manual: Check JENKINS_HOME/logs/

# Clear workspace (careful!)
# Go to job → More → Delete workspace
```

---

## 📚 Additional Resources

- **Maven Official Guide:** https://maven.apache.org/guides/
- **Jenkins Documentation:** https://jenkins.io/doc/
- **JUnit 5 Guide:** https://junit.org/junit5/docs/current/user-guide/
- **Git Book:** https://git-scm.com/book/en/v2
- **Jenkins Pipeline Syntax:** https://www.jenkins.io/doc/book/pipeline/

---

## 🔗 GitHub Integration

### Setting Up GitHub Webhook

1. Go to your GitHub repository
2. Navigate to **Settings** → **Webhooks**
3. Click **Add webhook**
4. Fill in:
   ```
   Payload URL: http://YOUR-JENKINS-SERVER:8080/github-webhook/
   Content Type: application/json
   Events: ✓ Push events
   ✓ Active
   ```
5. Click **Add webhook**

Now every `git push` will automatically trigger a Jenkins build!

---

## 📊 Environment Variables

### Jenkins Environment Variables
```groovy
// Available in Jenkinsfile
${BUILD_NUMBER}      // Current build number
${BUILD_ID}          // Build ID
${JOB_NAME}          // Job name
${WORKSPACE}         // Build workspace path
${BUILD_URL}         // Build URL
${GIT_BRANCH}        // Current Git branch
${GIT_COMMIT}        // Git commit SHA
${BUILD_TIMESTAMP}   // Build timestamp
```

### System Environment Variables
```bash
# Java
JAVA_HOME            // JDK installation path
java.version         // Detected by Maven

# Maven
MAVEN_HOME           // Maven installation path
M2_HOME              // Maven home (alternative)

# Git
GIT_HOME             // Git installation path (Windows)
```

---

## 🎓 Example: Complete Workflow

### Day 1: Initial Setup
```bash
# 1. Build locally and verify
cd c:\Win_Sem_2025_26\ADDA\FAT\Experiment1
mvn clean install
java -jar target/second-largest-finder-1.0.0.jar
# Output shows: Second Largest Element: 35, 90, -5 ✓

# 2. Initialize Git
git init
git config user.name "Developer"
git config user.email "dev@example.com"
git add .
git commit -m "Initial: Maven project with algorithm"

# 3. Push to GitHub
git remote add origin https://github.com/NupoorYadu/SecondLargestFinder-Build.git
git branch -M main
git push -u origin main
```

### Day 2: Configure Jenkins
```
1. Create Pipeline job in Jenkins
2. Repository: https://github.com/NupoorYadu/SecondLargestFinder-Build.git
3. Branch: */main
4. Script Path: Jenkinsfile
5. Trigger: Poll SCM (H/15 * * * *)
6. Save and Build Now

BUILD SUCCESS ✓ → See all 8 tests pass
               → See demo output with second largest numbers
               → JAR artifact archived
```

### Day 3+: Make Changes
```bash
# Make code changes
# ...editing files...

# Commit and push
git add .
git commit -m "Feature: Add new array test case"
git push origin main

# Jenkins automatically:
# ✓ Detects commit
# ✓ Clones repository
# ✓ Builds project
# ✓ Runs tests
# ✓ Creates JAR
# ✓ Runs demo (shows output)
# ✓ Archives artifacts

# Check build: http://localhost:8080/job/SecondLargestFinder-Build/
```

---

## ✅ Verification Checklist

After following this guide, verify:

```
LOCAL DEVELOPMENT:
  ☑ mvn clean install succeeds
  ☑ 8 tests pass
  ☑ JAR runs correctly
  ☑ Output shows "Second Largest Element: 35", "90", "-5"

GIT SETUP:
  ☑ Git repository initialized
  ☑ Remote configured to GitHub
  ☑ Commits pushed to main branch
  ☑ All files visible on GitHub

JENKINS SETUP:
  ☑ Jenkins job created
  ☑ Jenkinsfile recognized
  ☑ Build triggers without errors
  ☑ All 6 stages complete successfully
  ☑ Test results published
  ☑ Artifacts archived
  ☑ Demo stage shows output

AUTOMATION:
  ☑ Polling works (every 15 min)
  ☑ Webhook configured (on push)
  ☑ Build #N succeeds
  ☑ Console output visible
```

---

## 📞 Support & Documentation

- **Quick Reference:** See [QUICK_REFERENCE.md](QUICK_REFERENCE.md)
- **Jenkins Setup:** See [JENKINS_SETUP.md](JENKINS_SETUP.md)
- **Job Configuration:** See [JENKINS_JOB_CONFIGURATION.md](JENKINS_JOB_CONFIGURATION.md)
- **Build Output Example:** See [BUILD_OUTPUT_EXAMPLE.md](BUILD_OUTPUT_EXAMPLE.md)

---

## 📄 License

MIT License - Feel free to use and modify

---

## 👨‍💻 Author

Algorithm Demonstration Project  
Last Updated: 2026-04-16

---

**Happy Building! 🚀**
