pipeline {
    agent any
	    
    tools {
        maven "3.10.0-957.1.3.el7.x86_64"
        jdk '1.8.0'
    }
    parameters {
        credentials credentialType: 'com.cloudbees.plugins.credentials.impl.UsernamePasswordCredentialsImpl', defaultValue: '1726f219-79ab-44ce-ae8a-b4bb0d99878e', description: '', name: 'admin', required: false
        string defaultValue: '1.0.5', description: '', name: 'RELEASE_VERSION', trim: false
    }
    stages {
            stage("clone code") {
            steps {
                script {
                    // Let's clone the source
                    git 'https://github.com/Ya2e/test-jenkins.git';
                }
            }
        }
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
                sh 'mvn deploy'
            }
        }
    }
}
