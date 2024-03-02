pipeline {
    agent any
        environment {
        DOCKER_PATH = '/usr/bin/docker' // caminho completo para o comando docker
    }
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
                        dockerImage = sh(returnStdout: true, script: "${DOCKER_PATH} build -t myapp:latest .")
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
