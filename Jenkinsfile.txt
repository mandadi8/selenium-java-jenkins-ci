pipeline {
    agent any

    stages {

        stage('Build & Test') {
            steps {
                bat 'mvn clean test -Dbrowser=chrome -Dheadless=true'
            }
        }

    }
}