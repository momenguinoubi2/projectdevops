pipeline { 
    agent any
    stages {
        stage("Cloning Project"){
            steps {
                git 'https://github.com/momenguinoubi2/projectdevops.git'
            }
        }
        stage("Build Project"){
            steps {
                sh 'mvn compile'
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