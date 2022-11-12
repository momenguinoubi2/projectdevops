pipeline { 
    agent any
     stages {
       stage ('Checkout GIT'){
                steps {
                    echo 'pulling... ';
                        git branch :'Rami',
                        url : 'https://github.com/momenguinoubi2/projectdevops.git';
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