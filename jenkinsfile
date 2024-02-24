pipeline {
    agent any

    triggers {
        githubPush()
        githubPullRequest(branch: 'master')
    }

    stages {
        stage('Build') {
            steps {
                script {
                    checkout()
                    // Definir JDK 17
                    tool = 'jdk-17'
                    env.JAVA_HOME = tool
                    sh "export JAVA_HOME=$tool"
                    // Executar o build com Maven
                    sh 'mvn package'
                    // Envio de solicitação para atualizar o gráfico de dependências
                    sh 'curl -X POST -H "Authorization: token $GH_TOKEN" https://api.github.com/repos/vilelaricardo/CarStore/dependency-graph/snapshots'
                }
            }
        }

        stage('Update Dependency Graph') {
            steps {
                // Atualizar o gráfico de dependências
                sh 'curl -X POST -H "Authorization: token $GH_TOKEN" https://api.github.com/repos/vilelaricardo/CarStore/dependency-graph/snapshots'
            }
        }
    }
}
