package org.devops


//scan
def SonarScan(projectName,projectDesc,javaPath){
        withSonarQubeEnv("sonarqube")
        def scannerHome = "/usr/local/tcsa/base_service/sonar-scanner-4.2.0.1873-linux"
        def sonarDate = sh  returnStdout: true, script: 'date  +%Y%m%d%H%M%S'
        sonarDate = sonarDate - "\n"
    
        
        sh """ 
              cd  ${javaPath} && ${scannerHome}/bin/sonar-scanner  \
              -Dsonar.projectKey=${projectName} \
              -Dsonar.projectName=${projectName}  \
              -Dsonar.projectVersion=${sonarDate} \
              -Dsonar.ws.timeout=30 \
              -Dsonar.projectDescription=${projectDesc} \
              -Dsonar.links.homepage=http://www.baidu.com \
              -Dsonar.sources=src \
              -Dsonar.sourceEncoding=UTF-8 \
              -Dsonar.language=java \
              -Dsonar.java.binaries=target/classes \
              -Dsonar.java.test.binaries=target/test-classes \
              -Dsonar.java.surefire.report=target/surefire-reports
        """
    }
    
