pipeline {
    agent any
	    
    tools {
        maven "3.10.0-957.1.3.el7.x86_64"
        jdk '1.8.0_201'
    }
    
    triggers {
  		pollSCM 'H/2 * * * *'
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
                sh 'mvn deploy'
            }
        }
        
    //    stage('Release') {
     //       steps {
     //           echo 'Release..'
    //            sh 'mvn release:prepare release:perform' //-DtagNameFormat="@{version}"'  -Dusername=Ya2e -Dpassword=usmh0crb2'                      
      //      }
     //   }
        

        

    }
}
