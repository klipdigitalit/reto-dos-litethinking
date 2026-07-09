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
                    sh 'python3 -m venv .venv'
                    sh '.venv/bin/python -m pip install --upgrade pip'
                    sh '.venv/bin/python -m pip install -r requirements.txt'
                    sh '.venv/bin/python -m playwright install --with-deps'
                    sh '.venv/bin/python -m pytest'
                }
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