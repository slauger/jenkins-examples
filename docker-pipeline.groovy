pipeline {
  agent any

  stages {
    stage('Checkout') {
      steps {
        echo 'synchronize git repos...'
        checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [[$class: 'SubmoduleOption', disableSubmodules: false, parentCredentials: true, recursiveSubmodules: true, reference: '', trackingSubmodules: false]], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'credential-id', url: 'git@gitlab.com:project/project.git']]])
      }
    }
    stage('Build') {
      steps {
        echo 'Building docker image...'
        ansiColor('xterm') {
          script {
            app = docker.build("registry.gitlab.com/project/project/dockercontainer:latest")
          }
        }
      }
    }
    stage('Test') {
      steps {
        echo 'Running CI tests...'
        script {
          docker.image('registry.gitlab.com/project/project/dockercontainer:latest').inside {
            sh 'php -v'
          }
        }
      }
    }
    stage('Push') {
      steps {
        echo 'Pushing image to Registry'
        script {
          docker.withRegistry('https://registry.gitlab.com/project/project/dockercontainer:latest', 'credential-id') {
            app.push()
          }
        }
      }
    }
  }
}
