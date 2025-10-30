pipeline {
  agent any

  environment {
    IMAGE_NAME = "jenkins-test-app"
    DOCKERHUB_REPO = "mohammedzaid737/${env.IMAGE_NAME}"
  }

  stages {
    stage('Checkout') {
      steps {
        git branch: 'main', url: 'https://github.com/mohammedzaid737/docker-jenkins'
      }
    }

    stage('Build with Maven') {
      steps {
        // uses installed Maven tool if configured via Jenkins or container-installed mvn
        sh 'mvn -B clean package'
      }
    }

    stage('Build Docker Image') {
      steps {
        sh 'docker build -t ${DOCKERHUB_REPO}:latest .'
      }
    }

    stage('Push to Docker Hub') {
      steps {
        script {
          docker.withRegistry('https://index.docker.io/v1/', 'dockerhub-creds') {
            sh "docker push ${DOCKERHUB_REPO}:latest"
          }
        }
      }
    }
  }

  post {
    success { echo "Build and push succeeded" }
    failure { echo "Build failed - check console output" }
  }
}
