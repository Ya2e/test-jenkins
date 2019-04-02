pipeline {
    agent any
	    
    tools {
        maven "3.10.0-957.1.3.el7.x86_64"
        jdk '1.8.0'
    }
    stages {
        stage("clone code et clean") {
            steps {
                script {
                    // Let's clone the source
                    sh 'git clone https://github.com/Ya2e/test-jenkins.git';
                    sh 'mvn clean -f test-jenkins'
                }
            }
        }
        
        stage('Test') {
            steps {
                echo 'Testing..'
                sh 'mvn -f test test-jenkins'
            }
        }
        
        stage('Build') {
            steps {
                echo 'Building..'
                sh 'mvn package'
            }
        }

        stage('Deploy') {
            when {
              expression {
                currentBuild.result == null || currentBuild.result == 'SUCCESS' 
              }
            }
            steps {
                sh 'mvn deploy --batch-mode'
            }
        }
    }
}
