#!groovy

@Library('jenkinslibrary@master') _

//func from shareibrary
def tools = new org.devops.tools()
def build = new org.devops.build()


//env
String buildType = "${env.buildType}"
String buildShell = "${env.buildShell}"

String workspace = "/opt/jenkins/workspace"

pipeline{
    
    agent { node {  label "master"   //指定运行节点的标签或者名称
                    customWorkspace "${workspace}"   //指定运行工作目录（可选）
            }
    }
    

//流水线的阶段
stages{

    //阶段1 获取代码
    stage("CheckOut"){
        steps{
            script{
               tools.PrintMes("拉取代码","green")
               git branch: 'prod', credentialsId: 'd99f3ea4-2d2f-483a-8f1f-2ccd34f165bd', url: 'git@10.10.3.235:application-platform-department-group/qc-meeting.git'
            }
        }
    }
    stage("Build"){
        steps{
            script{
                    tools.PrintMes("执行打包","green")
                    build.Build(buildType,buildShell)
                   // artifactory.PushArtifact()
            }
        }
    }
    stage("sonar"){
        steps{
            script{
                tools.PrintMes("代码扫描","green")
            }
        }
    }
}
post {
    always{
        script{
            println("流水线结束后，经常做的事情")
        }
    }
        
    success{
        script{
            println("流水线成功后，要做的事情")
        }
        
    }
    failure{
        script{
            println("流水线失败后，要做的事情")
        }
    }
        
    aborted{
        script{
            println("流水线取消后，要做的事情")
        }
        
    }
}
}
