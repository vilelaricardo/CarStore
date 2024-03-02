pipeline {
    agent any
    tools {
        maven '3.9.6'
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B clean package'
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
                sh 'mvn test'
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
                    try {
                        dockerImage = docker.build('myapp:latest')
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
    }
}
