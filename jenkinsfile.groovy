node{
  def pom = readMavenPom file:'jee_tp/pom.xml'
}
pipeline{
  agent any
    stages {
      stage('Compile Stage'){
        steps{
          withMaven(maven : 'maven'){
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
