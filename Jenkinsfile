pipeline {
    agent any
     environnement {
     NEXUS_VERSION="nexus3"
     NEXUS_PROTOCOL="http"
     NEXUS_URL="192.168.1.12:8081"
     NEXUS_REPOSITORY="maven-release"
     NEXUS_CREDENTIAL_ID="nexus"
     registry="momenguinoubi2/projectdevops"
 }
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
    
     /*stage ('STATIC TEST WITH SONAR') {
       steps {
       withSonarQubeEnv('sonarqube-8.9.7-community') { 
                sh 'mvn sonar:sonar'
        }
      }
    }
  
   stage ('NEXUS DEPLOY') {
       steps {
       bat 'mvn deploy -DskipTests'
        
      }
    }*/
   

 stage ("upload nexus"){
steps {
script {
pom = readMavenPom file: "pom.xml";
                    filesByGlob = findFiles(glob: "target/*.${pom.packaging}");
                    echo "${filesByGlob[0].name} ${filesByGlob[0].path} ${filesByGlob[0].directory} ${filesByGlob[0].length} ${filesByGlob[0].lastModified}"
                    artifactPath = filesByGlob[0].path;
                    artifactExists = fileExists artifactPath;
                    if(artifactExists) {
                        echo "*** File: ${artifactPath}, group: ${pom.groupId}, packaging: ${pom.packaging}, version ${pom.version}";
                        nexusArtifactUploader(
                            nexusVersion: NEXUS_VERSION,
                            protocol: NEXUS_PROTOCOL,
                            nexusUrl: NEXUS_URL,
                            groupId: pom.groupId,
                            version: pom.version,
                            repository: NEXUS_REPOSITORY,
                            credentialsId: NEXUS_CREDENTIAL_ID,
                            artifacts: [
                                [artifactId: pom.artifactId,
                                classifier: '',
                                file: artifactPath,
                                type: pom.packaging],
                                [artifactId: pom.artifactId,
                                classifier: '',
                                file: "pom.xml",
                                type: "pom"]
                            ]
                        );
                    } else {
                        error "*** File: ${artifactPath}, could not be found";
                    }
}
}

}
    }
 }
