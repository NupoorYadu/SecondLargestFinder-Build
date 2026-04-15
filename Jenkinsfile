// Jenkinsfile for automating Maven build
// Pipeline as Code - Declarative approach

pipeline {
    agent any

    environment {
        PROJECT_NAME = 'second-largest-finder'
        BUILD_ARTIFACTS = 'target'
    }

    options {
        // Keep only the last 10 builds
        buildDiscarder(logRotator(numToKeepStr: '10'))
        // Timeout for the entire pipeline
        timeout(time: 30, unit: 'MINUTES')
        // Add timestamps to console output
        timestamps()
    }

    triggers {
        // Poll SCM every 15 minutes
        pollSCM('H/15 * * * *')
        // Or use webhook: GitHub will trigger on push
        // githubPush()
    }

    stages {
        stage('Checkout') {
            steps {
                echo '========== Checking out source code =========='
                checkout scm
                sh 'git log --oneline -5'
            }
        }

        stage('Build') {
            steps {
                echo '========== Building Maven project =========='
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo '========== Running unit tests =========='
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                echo '========== Packaging JAR artifact =========='
                sh 'mvn package -DskipTests'
            }
        }

        stage('Archive Artifacts') {
            steps {
                echo '========== Archiving build artifacts =========='
                archiveArtifacts artifacts: 'target/*.jar', 
                                 allowEmptyArchive: false
            }
        }
    }

    post {
        always {
            echo '========== Publishing test results =========='
            junit 'target/surefire-reports/*.xml'
        }

        success {
            echo "✓ Build SUCCESS - Build #${BUILD_NUMBER} completed successfully"
            // Add email notification for success
            emailext(
                subject: "Build SUCCESS: ${PROJECT_NAME} #${BUILD_NUMBER}",
                body: """
                Project: ${PROJECT_NAME}
                Build Number: ${BUILD_NUMBER}
                Build URL: ${BUILD_URL}
                Status: SUCCESS
                
                Artifacts available at: ${BUILD_URL}artifact/
                """,
                recipientProviders: [developers(), requestor()]
            )
        }

        failure {
            echo "✗ Build FAILED - Build #${BUILD_NUMBER} failed"
            // Add email notification for failure
            emailext(
                subject: "Build FAILED: ${PROJECT_NAME} #${BUILD_NUMBER}",
                body: """
                Project: ${PROJECT_NAME}
                Build Number: ${BUILD_NUMBER}
                Build URL: ${BUILD_URL}
                Status: FAILED
                
                Check console output at ${BUILD_URL} to view the results.
                """,
                recipientProviders: [developers(), requestor(), brokenBuildSuspects()]
            )
        }

        unstable {
            echo "⚠ Build UNSTABLE - Build #${BUILD_NUMBER} is unstable"
        }

        cleanup {
            echo '========== Cleanup =========='
            deleteDir()
            echo 'Workspace cleaned up'
        }
    }
}
