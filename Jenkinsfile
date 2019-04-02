pipeline {
    agent any
    
    tools {
        maven "3.10.0-957.1.3.el7.x86_64"
        jdk '1.8.0'
    }
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            when {
              expression {
                currentBuild.result == null || currentBuild.result == 'SUCCESS' 
              }
            }
            steps {
                sh 'deploy'
            }
        }
    }
}
