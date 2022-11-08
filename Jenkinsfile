pipeline {
    agent any
    stages{
            stage ('Checkout GIT'){
               steps {
       git branch: 'rania', 
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
  
    stage ('MVN build') {
      steps {
        sh 'mvn compile -e'
        echo 'compile stage done'

      }
    }
     /*stage ('MVN TEST') {
      steps {
        sh 'mvn test -e'
      }
    }*/
    
     stage ('STATIC TEST WITH SONAR') {
       steps {
       withSonarQubeEnv('sonarqube-8.9.7-community') { 
                sh 'mvn sonar:sonar'
        }
      }
    }
  
   stage ('NEXUS DEPLOY') {
       steps {
       sh 'mvn deploy -DskipTests'
        
      }
    }
    stage ('upload project to nexus'){
    steps {
           nexusArtifactUploader artifacts: [
           [artifactId: 'spring-boot-starter-parent',
            classifier: '', 
            file: 'projectdevops/target/spring-boot-starter-2.5.3.$[POM_PACKGING]', 
            type: '$[POM_PACKGING]']
            ],
             credentialsId: 'nexus', 
             groupId: 'org.springframework.boot', 
             nexusUrl: '192.168.1.12:8081',
              nexusVersion: 'nexus2',
               protocol: 'http',
                repository: 'maven-release',
                 version: '2.5.3'
    }}
    }
 }
