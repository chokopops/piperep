node {
    // Get Artifactory server instance, defined in the Artifactory Plugin administration page.
    def server = Artifactory.server "SERVER_ID"
    // Create an Artifactory Maven instance.
    def rtMaven = Artifactory.newMavenBuild()
    def buildInfo
    stage('Artifactory configuration') {
        // Tool name from Jenkins configuration
        rtMaven.tool = "Maven"
        // Set Artifactory repositories for dependencies resolution and artifacts deployment.
        rtMaven.deployer releaseRepo:'libs-release-local', snapshotRepo:'libs-snapshot-local', server: server
        rtMaven.resolver releaseRepo:'libs-release', snapshotRepo:'libs-snapshot', server: server
    }

    stage('Maven build') {
        buildInfo = rtMaven.run pom: 'jee_tp/pom.xml', goals: 'clean install'
    }

    stage('Publish build info') {
        server.publishBuildInfo buildInfo
        buildInfo = rtMaven.run pom: 'jee_tp/pom.xml', goals: 'clean install'
    }
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
