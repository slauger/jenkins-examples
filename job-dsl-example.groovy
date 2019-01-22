def config = new groovy.json.JsonSlurper().parseText(
    readFileFromWorkspace('config.json')
)

folder("os_updates") {
    displayName("os_updates")
    description("Jobs for applying yum updates to on a clustered environment")
}

config.each { stage_name, stage_settings -> 
    folder("os_updates/${stage_name}") {
        displayName("${stage_name}")
        description("Jobs for applying yum updates to on a clustered environment")
    }

    pipelineJob("os_updates/run_${stage_name}") {
        concurrentBuild(false)
        logRotator {
            numToKeep(30)
        }
        wrappers {
            timestamps()
        }
    }

    stage_settings.nodes.each { node_name, node_settings ->
        pipelineJob("os_updates/${stage_name}/${node_name}") {
            concurrentBuild(false)
            logRotator {
                numToKeep(30)
            }
            wrappers {
                timestamps()
            }
            environmentVariables {
                env('TARGET_HOST', node)
                keepBuildVariables(true)
            }
            definition {
                cpsScm {
                    scm {
                        git('git@gitlab.com:username/jenkins-jobs.git')
                    }
                    scriptPath('Jenkinsfile')
                }
            }
        }
    }
}
