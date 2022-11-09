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
              sh 'mvn sonar:sonar Dmaven.test.skip-true -e'
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