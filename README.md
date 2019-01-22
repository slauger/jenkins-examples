# jenkins-examples

Examples for Jenkins (Scripted Pipelines and Job DSL).

- Docker build pipeline
- Trigger other job from pipeline
- Skip stages
- Iterate over an array 
- Job DSL with JSON configuration

## Job DSL

See https://jenkinsci.github.io/job-dsl-plugin/

## Configuration as code

See https://jenkins.io/projects/jcasc/

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

## Install plugin via CLI

```
java -jar jenkins-cli.jar -s http://127.0.0.1:8080/ install-plugin <name>
```
