pipeline {
    agent any

    environment {
        JAVA_HOME = 'C:\\Program Files\\Java\\jdk-21.0.11'
    }

    stages {

        stage('Ejecución Serenity BDD') {
            steps {
                echo 'Ejecutando pruebas Serenity BDD...'

                dir('serenity-java') {
                    bat 'mvn clean verify'
                }
            }
        }

        stage('Ejecución Playwright Python') {
            steps {
                echo 'Ejecutando pruebas Playwright...'

                dir('playwright-python') {
                    bat 'python -m pip install -r requirements.txt'
                    bat 'python -m playwright install'
                    bat 'python -m pytest'
                }
            }
        }

    }

    post {

        always {

            archiveArtifacts artifacts: 'serenity-java/target/site/serenity/**', fingerprint: true
            archiveArtifacts artifacts: 'playwright-python/reports/**', fingerprint: true
            archiveArtifacts artifacts: 'playwright-python/screenshots/**', fingerprint: true

        }

        success {
            echo 'Automatización ejecutada correctamente.'
        }

        failure {
            echo 'Se presentaron errores durante la ejecución.'
        }

    }

}