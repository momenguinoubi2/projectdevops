pipeline { 
    agent any
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
        
        stage("SonarQube Analysis") {
            agent any  
            steps {
              sh 'mvn sonar:sonar -Dsonar.host.url=http://192.168.224.112:9000  -Dsonar.login=f43d3ff922968a6e9089e3b01df4469d69c1c59b -Dsonar.java.jdkHome=/usr/lib/jvm/jdk1.8.0_211'
            }
          }
       // stage("Unit Test"){
         //   steps {
           //     sh 'mvn test'
          //  }
        //}
        //stage("Packaging Project"){
          //  steps {
            //    sh 'mvn package'
            //}
        //}
    }
}