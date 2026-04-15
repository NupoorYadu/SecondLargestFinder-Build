# Jenkins Job Configuration Demonstration

## Overview
This document demonstrates how to configure a Jenkins Pipeline job for the SecondLargestFinder Maven project using both UI and configuration files.

---

## Method 1: UI-Based Configuration

### Step 1: Create New Pipeline Job
```
Jenkins Home → New Item → 
  Job Name: "SecondLargestFinder-Build"
  Type: Pipeline
  → OK
```

### Step 2: General Configuration
| Field | Value |
|-------|-------|
| Description | Maven Build Pipeline for Second Largest Finder Algorithm |
| ✓ GitHub project | https://github.com/your-org/second-largest-finder |
| Discard old builds | Keep 10 most recent builds |
| Build timeout | 30 minutes |

### Step 3: Build Triggers Configuration
**Option A: Poll SCM (Pull-based)**
```
✓ Poll SCM
  Schedule: H/15 * * * *
  (Polls every 15 minutes at random minute)
```

**Option B: GitHub Webhook (Push-based - Preferred)**
```
✓ GitHub hook trigger for GITScm polling
  (Requires GitHub plugin and webhook setup)
```

**Cron Format Explanation:**
```
H/15 * * * *
│  │  │ │ │ 
│  │  │ │ └─── Day of Week (0-6)
│  │  │ └───── Month (1-12)  
│  │  └─────── Day of Month (1-31)
│  └─────────── Hour (0-23)
└────────────── Minute (*/15 = every 15 min)

Common Examples:
H * * * *     → Every hour at random minute
H/30 * * * *  → Every 30 minutes
H 0 * * *     → Once each day
```

### Step 4: Pipeline Configuration

**Definition Type**: "Pipeline script from SCM"

```
SCM: Git
├── Repository URL: https://github.com/your-org/second-largest-finder.git
├── Credentials: [github-credentials]
├── Branches to build: */main
└── Script Path: Jenkinsfile
```

**Alternative: Inline Pipeline Script**
> If not using SCM, use "Pipeline script" and paste Jenkinsfile content directly

### Step 5: Advanced Options

**Maven Configuration:**
```
Environment Variable: MAVEN_HOME = /usr/share/maven
(or configure in Global Tool Configuration)
```

**Email Notifications:**
```
✓ Attach build log
✓ Compress log before sending
Recipient List: ${DEFAULT_RECIPIENTS}
```

---

## Method 2: Jenkins CLI Configuration

### Create Job from XML Configuration
```bash
# Export existing job
java -jar jenkins-cli.jar -s http://localhost:8080 \
  get-job SecondLargestFinder > job-config.xml

# Create new job from XML
java -jar jenkins-cli.jar -s http://localhost:8080 \
  create-job SecondLargestFinder < jenkins-job-config.xml

# Update existing job
java -jar jenkins-cli.jar -s http://localhost:8080 \
  update-job SecondLargestFinder < jenkins-job-config.xml
```

---

## Method 3: Pipeline Script Details

### Complete Jenkinsfile Walkthrough

```groovy
pipeline {
    agent any                    // Run on any available agent
    
    environment {
        // Define pipeline-wide environment variables
        MAVEN_HOME = tool 'maven-3.8.1'
        PATH = "${MAVEN_HOME}/bin:${PATH}"
        PROJECT_NAME = 'second-largest-finder'
    }
    
    options {
        buildDiscarder(logRotator(numToKeepStr: '10'))
        timeout(time: 30, unit: 'MINUTES')
        timestamps()             // Prefix each log line with timestamp
    }
    
    triggers {
        pollSCM('H/15 * * * *')  // Poll SCM every 15 minutes
    }
    
    stages {
        stage('Checkout') { ... }
        stage('Build') { ... }
        stage('Test') { ... }
        stage('Package') { ... }
        stage('Archive Artifacts') { ... }
    }
    
    post {
        always { ... }           // Always runs
        success { ... }          // Runs if successful
        failure { ... }          // Runs if failed
        unstable { ... }         // Runs if unstable
        cleanup { ... }          // Always runs at end
    }
}
```

### Stage Breakdown

#### Stage 1: Checkout
```groovy
stage('Checkout') {
    steps {
        echo '========== Checking out source code =========='
        checkout scm
        sh 'git log --oneline -5'
    }
}
```
**Purpose**: Clone Git repository
**SCM**: Configured in job definition
**Output**: Git commit log

#### Stage 2: Build
```groovy
stage('Build') {
    steps {
        echo '========== Building Maven project =========='
        sh 'mvn clean compile'
    }
}
```
**Purpose**: Compile source code
**Command**: `mvn clean compile`
- `clean` → Remove previous build artifacts
- `compile` → Compile source files

#### Stage 3: Test
```groovy
stage('Test') {
    steps {
        echo '========== Running unit tests =========='
        sh 'mvn test'
    }
}
```
**Purpose**: Run unit tests
**Command**: `mvn test`
**Output**: Test results stored in target/surefire-reports/

#### Stage 4: Package
```groovy
stage('Package') {
    steps {
        echo '========== Packaging JAR artifact =========='
        sh 'mvn package -DskipTests'
    }
}
```
**Purpose**: Create JAR archive
**Command**: `mvn package -DskipTests`
- `-DskipTests` → Skip tests (already run in previous stage)
**Output**: second-largest-finder-1.0.0.jar

#### Stage 5: Archive Artifacts
```groovy
stage('Archive Artifacts') {
    steps {
        echo '========== Archiving build artifacts =========='
        archiveArtifacts artifacts: 'target/*.jar', 
                         allowEmptyArchive: false
    }
}
```
**Purpose**: Store JAR in Jenkins build workspace
**Artifacts**: target/*.jar

### Post-Build Actions

```groovy
post {
    always {
        junit 'target/surefire-reports/*.xml'
    }
    
    success {
        emailext(
            subject: "Build SUCCESS: ${PROJECT_NAME} #${BUILD_NUMBER}",
            body: "...",
            recipientProviders: [developers(), requestor()]
        )
    }
    
    failure {
        emailext(
            subject: "Build FAILED: ${PROJECT_NAME} #${BUILD_NUMBER}",
            body: "...",
            recipientProviders: [developers(), requestor(), brokenBuildSuspects()]
        )
    }
    
    cleanup {
        deleteDir()
    }
}
```

---

## Configuration File Variables

### Environment Variables Used

| Variable | Purpose | Example |
|----------|---------|---------|
| `${BUILD_NUMBER}` | Current build number | 42 |
| `${JOB_NAME}` | Job name | SecondLargestFinder-Build |
| `${BUILD_ID}` | Build ID | 42 |
| `${WORKSPACE}` | Build workspace path | /var/jenkins/workspace/job |
| `${BUILD_URL}` | URL to build | http://jenkins:8080/job/name/42/ |
| `${GIT_BRANCH}` | Git branch | main |
| `${GIT_COMMIT}` | Git commit SHA | abc123def456 |

---

## Git Integration

### GitHub Webhook Setup

1. **GitHub Repository Settings**:
   ```
   Settings → Webhooks → Add Webhook
   Payload URL: http://jenkins-server:8080/github-webhook/
   Content Type: application/json
   Events: Push events
   ✓ Active
   ```

2. **Jenkins Configuration**:
   - Install GitHub plugin
   - Manage Jenkins → Configure System → GitHub
   - Add GitHub token/credentials

3. **Verification**:
   ```bash
   # Test webhook
   curl -X POST http://jenkins-server:8080/github-webhook/
   ```

---

## Build Execution Flow

```
┌─────────────────────────────────────────┐
│   Git Trigger (Push or Poll)            │
└──────────────┬──────────────────────────┘
               ▼
┌─────────────────────────────────────────┐
│   1. Checkout Stage                     │
│   - Clone Git repo                      │
│   - Checkout specified branch           │
└──────────────┬──────────────────────────┘
               ▼
┌─────────────────────────────────────────┐
│   2. Build Stage                        │
│   - mvn clean compile                   │
│   - Compile Java source files           │
└──────────────┬──────────────────────────┘
               ▼
┌─────────────────────────────────────────┐
│   3. Test Stage                         │
│   - mvn test                            │
│   - Run JUnit tests                     │
└──────────────┬──────────────────────────┘
               ▼
┌─────────────────────────────────────────┐
│   4. Package Stage                      │
│   - mvn package -DskipTests             │
│   - Create JAR artifact                 │
└──────────────┬──────────────────────────┘
               ▼
┌─────────────────────────────────────────┐
│   5. Archive Artifacts                  │
│   - Save JAR to Jenkins                 │
└──────────────┬──────────────────────────┘
               ▼
┌─────────────────────────────────────────┐
│   Post Actions                          │
│   - Publish test results                │
│   - Send notifications                  │
│   - Cleanup workspace                   │
└──────────────┬──────────────────────────┘
               ▼
          Build Complete
   (Success/Failure/Unstable)
```

---

## Monitoring and Troubleshooting

### View Build Console
```
Jenkins → Job → Build #N → Console Output
```

### Common Issues and Solutions

| Issue | Cause | Solution |
|-------|-------|----------|
| Build fails at Checkout | Git credentials missing | Add GitHub credentials in Jenkins |
| Maven not found | Maven not configured | Configure Maven in Global Tool Configuration |
| Tests fail | JDK version mismatch | Configure correct JDK in job or Global Settings |
| SCM trigger not working | API not accessible | Check network/firewall settings |
| Email not sent | SMTP not configured | Configure SMTP in Jenkins System Configuration |

### Debug Pipeline
```groovy
// Add debug output
stage('Debug') {
    steps {
        sh 'mvn --version'
        sh 'java -version'
        sh 'git --version'
        sh 'echo "WORKSPACE: $WORKSPACE"'
        sh 'echo "BUILD_URL: $BUILD_URL"'
    }
}
```

---

## Performance Tips

1. **Enable Pipeline Syntax Documentation**:
   ```
   Job → Pipeline Syntax → Help
   ```

2. **Use Declarative Pipeline** - Simpler, more readable than Scripted

3. **Parallel Stages** (Advanced):
   ```groovy
   parallel {
       stage('Test') { steps { sh 'mvn test' } }
       stage('Coverage') { steps { sh 'mvn jacoco:report' } }
   }
   ```

4. **Cache Dependencies**:
   ```bash
   # In Jenkins workspace
   ~/.m2/repository  # Maven downloads here
   ```

---

## Success Indicators

✓ Job creates successfully  
✓ Code checks out from Git  
✓ Maven builds without errors  
✓ Tests pass  
✓ JAR artifact created  
✓ Artifacts archived in Jenkins  
✓ Build notifications sent  

---

## Reference Links

- [Jenkins Documentation](https://jenkins.io/doc/)
- [Declarative Pipeline](https://jenkins.io/doc/book/pipeline/syntax/)
- [GitHub Integration](https://plugins.jenkins.io/github/)
- [Maven Plugin](https://plugins.jenkins.io/maven-plugin/)
