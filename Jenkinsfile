pipeline {
    agent any
	    
    tools {
        maven "3.10.0-957.1.3.el7.x86_64"
        jdk '1.8.0'
    }
    stages {
    //test de commit
     	 stage('Check commit message') {
		     when { changelog '.*\\[maven-release-plugin\\].*' }
		     steps {
		       script {
		          pom = readMavenPom file: 'pom.xml'
		          currentBuild.displayName = pom.version
		          currentBuild.result = 'NOT_BUILT'
		       }
		       error('Skipping release build')
		     }
		}
        stage('Build') {
            steps {
                echo 'Building..'
                sh 'mvn clean install package -DskipTests'
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
                sh 'mvn deploy --batch-mode'
            }
        }
    }
}
