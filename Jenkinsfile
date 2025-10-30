pipeline {
    agent any

    environment {
        DOCKERHUB_CREDENTIALS = credentials('dockerhub-creds')
        IMAGE_NAME = "mohammedzaid737/jenkins-test-app"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/mohammedzaid737/docker-jenkins.git'
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    def app = docker.build("${IMAGE_NAME}:latest")
                }
            }
        }

        stage('Push to Docker Hub') {
            steps {
                script {
                    withDockerRegistry([credentialsId: 'dockerhub-creds', url: 'https://index.docker.io/v1/']) {
                        sh 'docker push mohammedzaid737/jenkins-test-app:latest'
                    }
                }
            }
        }

    }

    post {
        failure {
            echo 'Build failed - check logs.'
        }
        success {
            echo 'Build and push successful!'
        }
    }
}
