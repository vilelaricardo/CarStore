pipeline {
    agent any
    tools {
        maven '3.9.6'
    }
    stages {
        stage('Build') {
            steps {
                bat 'mvn package'
            }
            post {
                success {
                    echo 'Build successful!'
                }
                failure {
                    echo 'Build failed!'
                }
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
stage('Build Docker Image') {
    steps {
        script {
            def dockerImage
            def dockerfilePath = "Dockerfile"
            try {
                if (fileExists(dockerfilePath)) {
                    dockerImage = bat(returnStdout: true, script: "docker build -t myapp:latest .")
                } else {
                    echo "Dockerfile not found at ${dockerfilePath}"
                    currentBuild.result = 'FAILURE'
                }
            } catch (Exception e) {
                echo "Failed to build Docker image: ${e.message}"
                currentBuild.result = 'FAILURE'
            }
            if (dockerImage != null) {
                echo 'Docker Image built successfully'
            }
        }
    }
}
stage('Deploy on QA Environment') {
            steps {
                script {
                    try {
                        bat "docker run -d -p 8080:8080 myapp:latest"
                    } catch (Exception e) {
                        echo "Failed to run Docker container: ${e.message}"
                        currentBuild.result = 'FAILURE'
                    }
                }
}
    }

    stage('Deploy on Stage Environment') {
                steps {
                    script {
                        try {
                            bat "docker run -d -p 8083:8080 myapp:latest"
                        } catch (Exception e) {
                            echo "Failed to run Docker container: ${e.message}"
                            currentBuild.result = 'FAILURE'
                        }
                    }
    }
        }
}
}
