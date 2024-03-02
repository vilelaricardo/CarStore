pipeline {
    agent any
    tools {
        maven '3.9.6'
        docker 'docker'
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
                    def imageName = 'myapp' 
                    def imageTag = 'latest'
                    docker.build("$imageName:$imageTag")
                }
            }
        }
    }
}
