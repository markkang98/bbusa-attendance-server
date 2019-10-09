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
          echo 'Stage 1 is working'
        }
      }
    }
  stage('Stage 2') {
      steps {
        script {
          echo 'Stage 2 is working'
        }
      }
    }
  }
}