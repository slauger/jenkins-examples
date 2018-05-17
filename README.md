# jenkins-examples

Examples for Jenkins (Scripted Pipelines and Job DSL).

## Docker build pipeline

```
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
```

## Trigger other job from pipeline

```
pipeline {
  agent any
  
  stages {
    stage('Build other projects') {
      steps {
        build job: 'patch1', parameters: [[$class: 'BooleanParameterValue', name: 'force', value: false]]
        build job: 'patch2', parameters: [[$class: 'BooleanParameterValue', name: 'force', value: true]]
      }
    }
  }
}

```

## Skip stages

```
pipeline {
    agent any
    
    parameters {
        booleanParam(defaultValue: false, description: 'Force to tun', name: 'force')
    }
    
    stages {
        stage('Check patchlevel') {
		    when {
			    expression { params.force == true }
			}
            steps {
                script {
                        println("Hello World")
                    }
                }
            }
        }
    }
}
```

## Plugins

- https://wiki.jenkins-ci.org/display/JENKINS/Ansible+Plugin
- https://wiki.jenkins.io/display/JENKINS/AnsiColor+Plugin
- https://wiki.jenkins.io/display/JENKINS/Nexus+Artifact+Uploader
- https://wiki.jenkins-ci.org/display/JENKINS/Blue+Ocean+Plugin
- https://wiki.jenkins.io/display/JENKINS/Build+Token+Root+Plugin
- https://wiki.jenkins.io/display/JENKINS/Build-timeout+Plugin
- https://wiki.jenkins.io/display/JENKINS/Build+Timestamp+Plugin
- https://plugins.jenkins.io/build-token-trigger
- https://wiki.jenkins.io/display/JENKINS/CloudBees+Simple+Disk+Usage+Plugin
- https://wiki.jenkins.io/display/JENKINS/CloudBees+Docker+Build+and+Publish+plugin
- https://wiki.jenkins.io/display/JENKINS/CloudBees+Docker+Hub+Notification
- https://wiki.jenkins-ci.org/display/JENKINS/Conditional+BuildStep+Plugin
- https://wiki.jenkins.io/display/JENKINS/Docker+Commons+Plugin#
- https://wiki.jenkins.io/display/JENKINS/Credentials+Plugin
- https://wiki.jenkins.io/display/JENKINS/EnvInject+Plugin
- https://wiki.jenkins.io/display/JENKINS/Job+DSL+Plugin
- https://wiki.jenkins.io/display/JENKINS/LDAP+Plugin
- https://wiki.jenkins.io/display/JENKINS/Matrix+Authorization+Strategy+Plugin
- https://wiki.jenkins.io/display/JENKINS/Nexus+Artifact+Uploader
- https://wiki.jenkins.io/display/JENKINS/Pipeline+Plugin
- https://wiki.jenkins.io/display/JENKINS/Rebuild+Plugin
- https://wiki.jenkins.io/display/JENKINS/SSH+Agent+Plugin
- https://wiki.jenkins-ci.org/display/JENKINS/SSH+Slaves+plugin
- https://wiki.jenkins.io/display/JENKINS/Workspace+Cleanup+Plugin
- http://wiki.jenkins-ci.org/display/JENKINS/Docker+Pipeline+Plugin
