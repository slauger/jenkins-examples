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
