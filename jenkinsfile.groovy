pipeline{
  agent any
  tools {
        maven 'maven'
    }
    stages {
      stage('Compile Stage'){
        steps{
          withMaven(maven : 'maven'){
            sh 'mvn clean compile'
            bat ' mvn -f jee_tp/pom.xml clean install'
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
