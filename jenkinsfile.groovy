node{
  def pom = readMavenPom file:'jee_tp/pom.xml'
}
pipeline{
  agent any
  tools {
        maven 'maven'
    }
    stages {
      stage('Compile Stage'){
        steps{
          withMaven(maven : 'maven'){
            bat ' mvn -f ABC/pom.xml clean install'
            sh 'mvn clean compile'
          }
        }
      }
      
      stage ('Testing Stage'){
        steps{
          withMaven(maven : 'maven'){
            sh 'mvn test'
          }
        }
      }
      
      stage ('Deployment Stage'){
        steps {
          withMaven(maven : 'maven'){
            sh 'mvn deploy'
          }
        }
      }
    }
  }
