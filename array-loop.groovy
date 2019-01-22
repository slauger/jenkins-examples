pipeline { 
  stages { 
    stage('Run Jobs') { 
      steps { 
        script { 
          def nodes = "${env.SERVERS}".split(" ") 
          for (i = 0; i < nodes.size(); i++) { 
            build job: "`tests/${env.NAME}/" + nodes[i], propagate: false 
          } 
        } 
      } 
    } 
  } 
}
