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
        stage("mvn build") {
            steps {
                script {
                    // If you are using Windows then you should use "bat" step
                    // Since unit testing is out of the scope we skip them
                    sh "mvn package -DskipTests=true"
                }
            }
        }
        stage("Unit Test"){
            steps {
                sh 'mvn test'
            }
        }
        stage("Packaging Project"){
            steps {
            /   sh 'mvn package'
            }
        }
    }
}