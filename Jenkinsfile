pipeline {
    agent any

    stages {

        stage('Ejecución Serenity BDD') {
            steps {
                dir('serenity-java') {
                    catchError(buildResult: 'UNSTABLE', stageResult: 'FAILURE') {
                        sh 'mvn clean verify'
                    }
                }
            }
        }

        stage('Ejecución Playwright Python') {
            steps {
                dir('playwright-python') {
                    catchError(buildResult: 'UNSTABLE', stageResult: 'FAILURE') {
                        sh 'python3 -m pip install -r requirements.txt'
                        sh 'python3 -m playwright install --with-deps'
                        sh 'python3 -m pytest'
                    }
                }
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'serenity-java/target/site/serenity/**', allowEmptyArchive: true
            archiveArtifacts artifacts: 'serenity-java/target/surefire-reports/**', allowEmptyArchive: true
            archiveArtifacts artifacts: 'playwright-python/reports/**', allowEmptyArchive: true
            archiveArtifacts artifacts: 'playwright-python/screenshots/**', allowEmptyArchive: true
        }
    }
}