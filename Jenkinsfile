pipeline { 
    agent any
    
     environment {
        // This can be nexus3 or nexus2
        NEXUS_VERSION = "nexus3"
        // This can be http or https
        NEXUS_PROTOCOL = "http"
        // Where your Nexus is running
        NEXUS_URL = "192.168.1.112:8081"
        // Repository where we will upload the artifact
        NEXUS_REPOSITORY = "maven-releases"
        // Jenkins credential id to authenticate to Nexus OSS
        NEXUS_CREDENTIAL_ID = "nexus"
           
       // DOCKERHUB_CREDENTIALS= credentials('dockerhub') 
        
    }
    
   
    
    
    stages {
        stage("Cloning Project"){
            steps {
                git branch: 'momen', 
                url: 'https://github.com/momenguinoubi2/projectdevops.git'
                echo 'checkout stage'
            }
        }
        
        stage ('MVN clean') {
      steps {
        sh 'mvn clean -e'
        echo 'Build stage done'
      }
    }
    
        stage("Build Project"){
            steps {
                 sh 'mvn compile -X -e'
                  echo 'compile stage done'
            }
        }
        
        //stage("SonarQube Analysis") {
            //agent any  
            //steps {
              //        sh 'mvn sonar:sonar -Dsonar.projectKey=projetachat -Dsonar.host.url=http://192.168.1.112:9000 -Dsonar.login=7ea7804d15c1be815311a98d2c17bd0bfc193e12 -Dsonar.exclusions=**/*.java'           
            //}
          //}
          
          stage("mvn build") {
            steps {
                script {
                    // If you are using Windows then you should use "bat" step
                    // Since unit testing is out of the scope we skip them
                    sh "mvn package -DskipTests=true"
                }
            }
        }
       }
}