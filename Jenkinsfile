pipeline {
  agent any
  tools {
          maven 'Maven 3.6.2'
          jdk 'jdk9'
     }
  stages {
  stage('Build') {
      steps {
      sh 'mvn clean install'
        script {
          echo 'Build successful'
        }
      }
    }
  stage('Test') {
      steps {
        script {
        sh 'mvn test'
          echo 'All tests passed'
        }
      }
    }
  }
}