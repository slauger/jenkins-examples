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
