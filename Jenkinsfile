pipeline {
    agent any

    stages {
        stage('start') {
            steps {
                withMaven(maven: 'maven_3_6_3') {
                    sh 'mvn clean install -Denv=${env} -Dscope=${scope}'
                }
            }
        }
    }
}