pipeline {
    agent any

    stages {
        stage('Test Jenkins') {
            steps {
                echo 'JENKINSFILE IS RUNNING'
                bat 'java -version'
                bat 'mvn -version'
            }
        }

        stage('Run Selenium Tests') {
            steps {
                bat 'mvn clean test -Dbrowser=chrome -Dheadless=false'
            }
        }
    }
}