pipeline {
    agent {
        label "master"
    }
    tools {
        // Note: this should match with the tool name configured in your jenkins instance (JENKINS_URL/configureTools/)
        maven "3.10.0-957.1.3.el7.x86_64"
        jdk '1.8.0'
    }
    
    parameters {
        credentials credentialType: 'com.cloudbees.plugins.credentials.impl.UsernamePasswordCredentialsImpl', defaultValue: '1726f219-79ab-44ce-ae8a-b4bb0d99878e', description: '', name: 'admin', required: false
        string defaultValue: '1.0.5', description: '', name: 'RELEASE_VERSION', trim: false
    }
    environment {
        // This can be nexus3 or nexus2
        NEXUS_VERSION = "nexus2"
        // This can be http or https
        NEXUS_PROTOCOL = "http"
        // Where your Nexus is running
        NEXUS_URL = "localhost:8081/nexus"
        // Repository where we will upload the artifact
        NEXUS_REPOSITORY = "releases"
        // Jenkins credential id to authenticate to Nexus OSS
        //NEXUS_CREDENTIAL_ID = credentials('1726f219-79ab-44ce-ae8a-b4bb0d99878e')
        NEXUS_CREDENTIAL_ID='1726f219-79ab-44ce-ae8a-b4bb0d99878e'
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
        stage("mvn build") {
            steps {
                script {
                    // If you are using Windows then you should use "bat" step
                    // Since unit testing is out of the scope we skip them
                    sh "mvn package -DskipTests=true"
                }
            }
        }
        stage('publish to nexus') {
          steps {
            nexusArtifactUploader artifacts: [[artifactId: 'test-nexus', 
        		classifier: 'jar', 
        		file: '/var/lib/tomcat/webapps/jenkins/jobs/test-build-mvn-nexus/workspace/target/projet-maven-0.0.1-SNAPSHOT.jar', 
        		type: 'jar']], 
        		credentialsId: NEXUS_CREDENTIAL_ID, 
        		groupId: 'test-build-mv-nexus', 
        		nexusUrl: NEXUS_URL, 
        		nexusVersion: NEXUS_VERSION, 
        		protocol: NEXUS_PROTOCOL, 
        		repository: NEXUS_REPOSITORY, 
        		version: '${RELEASE_VERSION}'
                 }
        }
    }
}
