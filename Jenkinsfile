pipeline {

	agent any

	stages {
		
		/*stage('Junit + Mockito Test') {
			steps {
				sh 'mvn test'
			      } 
		}*/
		stage('Build Artifact - Maven') {
			steps {
				sh "mvn clean package -DskipTests=true"
				archive 'target/*.jar'
			      }
		}
		       
		stage('SonarQube + JacOcO Analysis') {
			steps {
				sh "mvn  sonar:sonar -Dsonar.projectKey=devops   -Dsonar.host.url=http://192.168.1.135:9000  -Dsonar.login=39a807994ce6ab370ac17c338eac6c6169b0b245"
			}
		        post {
				always {
					jacoco execPattern: 'target/jacoco.exec'
				       }    
			    } 
		 }  
		 stage('Sonatype/Nexus deploy') {
			steps {
				//sh 'mvn clean deploy -DskipTests'
				sh'mvn clean deploy -Dmaven.test.skip=true -Dresume=false'
			      }
		 } 
	/*	stage('Docker Build and Push') {
                       steps {
                               withDockerRegistry([credentialsId: "docker-hub", url: ""]) {
         			  sh 'printenv'
        			  sh 'docker build -t malekhm/spring .'
	 			  sh 'docker tag malekhm/spring malekhm/spring:latest'
         			  sh 'docker push malekhm/spring:latest'
         			}
     			  }
    		}*/
		 stage('Docker compose') {
      		      steps {
         parallel(
           "Docker compose": {
               sh 'docker-compose up '
           },
           "Delete running containers": {
		       sh 'sleep 3m '
               sh 'docker rm -f ci-spring ci-db ci-angular '
           }
         )
       }
     }
	}  
			post {
				success {

					echo "passed"
				}    
			       failure {
				       echo "failed"
				
		                }
		}
}
