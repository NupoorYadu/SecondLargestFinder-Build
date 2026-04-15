# Jenkins Setup and Configuration Guide

## Prerequisites
- Jenkins server (2.361.1 or higher recommended)
- Required Plugins:
  - Pipeline plugin
  - Git plugin
  - Maven Integration plugin
  - Email Extension plugin
  - Timestamper plugin

## Step 1: Install Required Plugins

1. Go to **Manage Jenkins** → **Manage Plugins**
2. Install the following plugins (if not already installed):
   - Pipeline
   - Git
   - Maven Integration
   - Email Extension
   - Timestamper

## Step 2: Configure Global Tools

### Configure Maven
1. Go to **Manage Jenkins** → **Global Tool Configuration**
2. Scroll to **Maven** section
3. Click **Add Maven**
   - **Name**: `maven-3.8.1` (or your version)
   - **MAVEN_HOME**: `/usr/share/maven` (Linux) or `C:\Program Files\Maven` (Windows)
   - Or select "Install automatically"
4. Save

### Configure JDK (if needed)
1. In the same Global Tool Configuration page
2. Scroll to **JDK** section
3. Configure JDK 11+ with appropriate path

## Step 3: Create a New Pipeline Job

### Method 1: Using Jenkinsfile from Git Repository

1. **New Item** → Enter job name (e.g., "SecondLargestFinder") → **Pipeline** → OK
2. **General Tab**:
   - Check "GitHub project" (if using GitHub)
   - Enter project URL
3. **Build Triggers Tab**:
   - ✓ **Poll SCM**: `H/15 * * * *` (check every 15 minutes)
   - Or ✓ **GitHub hook trigger** (if using GitHub webhook)
4. **Pipeline Tab**:
   - **Definition**: Select "Pipeline script from SCM"
   - **SCM**: Select "Git"
   - **Repository URL**: `<your-git-repo-url>`
   - **Credentials**: Add credentials if private repo
   - **Branches to build**: `*/main` (or your branch)
   - **Script Path**: `Jenkinsfile`
5. **Save**

### Method 2: Using Pipeline Script Directly

If not using SCM:
1. **Pipeline Tab** → **Definition**: "Pipeline script"
2. Paste the Jenkinsfile content into the script area

## Step 4: Configure Email Notifications (Optional)

### Set up Email
1. **Manage Jenkins** → **Configure System**
2. Scroll to **Extended E-mail Notification** section
3. **SMTP server**: `smtp.gmail.com` (example)
4. **SMTP Port**: `587`
5. **SMTP Authentication**:
   - Username: your-email@gmail.com
   - Password: app-password or token
   - ✓ Use SSL/TLS
6. **Default user e-mail address**: job-notifications@example.com
7. Test email configuration
8. Save

## Step 5: Git Configuration

### Initialize Git Repository (if not already)
```bash
cd /path/to/project
git init
git add .
git commit -m "Initial commit"
git remote add origin <repository-url>
git push -u origin main
```

### Supported Git Hosting
- GitHub
- GitLab
- Bitbucket
- Azure DevOps
- Self-hosted Git server

## Step 6: Run the Build

1. Go to your Pipeline job
2. Click **Build Now**
3. View build progress in build logs

## Understanding the Pipeline

### Pipeline Stages
```
Checkout → Build → Test → Package → Archive Artifacts
     ↓       ↓       ↓        ↓            ↓
   (SCM)  (mvn      (mvn    (mvn       (Store
   clone) compile)  test)   package)    JAR)
```

### Build Artifacts
- JAR file: `target/second-largest-finder-1.0.0.jar`
- Test reports: `target/surefire-reports/`

### Post-Build Actions
- **Success**: Email notification sent to developers
- **Failure**: Email sent to developers + broken build suspects
- **Cleanup**: Workspace cleaned up

## Troubleshooting

### Build Fails - Maven Not Found
**Solution**: 
- Configure Maven in Global Tool Configuration
- Or install Maven on the Jenkins agent

### Git Clone Fails
**Solution**:
- Check Git plugin is installed
- Verify repository URL and credentials
- Check network connectivity

### Tests Fail
**Solution**:
- Check JDK version matches project requirements
- Verify test data is correct
- Run `mvn test` locally to debug

### Pipeline Syntax Error
**Solution**:
- Use Jenkins Pipeline Syntax Generator
- Go to Pipeline job → Pipeline Syntax
- Build steps using the visual editor

## Performance Optimization

### Caching Dependencies
Add to Jenkinsfile to cache Maven dependencies:
```groovy
options {
    buildDiscarder(logRotator(numToKeepStr: '10'))
}
```

### Parallel Stages (Advanced)
```groovy
parallel {
    stage('Test') {
        steps { sh 'mvn test' }
    }
    stage('SonarQube Analysis') {
        steps { sh 'mvn sonar:sonar' }
    }
}
```

## Monitoring and Logs

### View Build Logs
1. Click on build number
2. Select "Console Output"

### Historical Trends
- Jenkins keeps build history
- Access it via job dashboard
- View success/failure trends

## Security Best Practices

1. **Use Credentials Plugin**:
   - Store Git credentials securely
   - Use credentials binding in pipeline

2. **Restrict Job Permissions**:
   - Use Role-based Authorization Strategy
   - Limit who can trigger builds

3. **Git Webhook Security**:
   - Use GitHub/GitLab tokens
   - Validate webhook signatures

## Advanced Configuration

### Add Code Coverage
Add to pom.xml:
```xml
<plugin>
    <groupId>org.jacoco</groupId>
    <artifactId>jacoco-maven-plugin</artifactId>
    <version>0.8.8</version>
    <executions>
        <execution>
            <goals>
                <goal>prepare-agent</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

### Add FindBugs/SpotBugs
```xml
<plugin>
    <groupId>com.github.spotbugs</groupId>
    <artifactId>spotbugs-maven-plugin</artifactId>
    <version>4.7.2.1</version>
</plugin>
```

## Reference Documentation
- [Jenkins Documentation](https://www.jenkins.io/doc/)
- [Pipeline Plugin Documentation](https://plugins.jenkins.io/workflow-aggregator/)
- [Maven Plugin Documentation](https://plugins.jenkins.io/maven-plugin/)

