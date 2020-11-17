#!groovy

@Library('jenkinslibrary@master') _

//func from shareibrary
def tools = new org.devops.tools()

pipeline{
//指定运行此流水线的节点
agent { node { label "qc-slave"}}
    

//流水线的阶段
stages{

    //阶段1 获取代码
    stage("CheckOut"){
        steps{
            script{
               tools.PrintMes("拉取代码","green")
               println("拉取代码")
            }
        }
    }
    stage("Build"){
        steps{
            script{
                tools.PrintMes("运行构建","green")
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
