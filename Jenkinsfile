post {
    always {
        archiveArtifacts(
            artifacts: 'serenity-java/target/site/serenity/**',
            allowEmptyArchive: true
        )

        archiveArtifacts(
            artifacts: 'serenity-java/target/surefire-reports/**',
            allowEmptyArchive: true
        )

        archiveArtifacts(
            artifacts: 'playwright-python/reports/**',
            allowEmptyArchive: true
        )

        archiveArtifacts(
            artifacts: 'playwright-python/screenshots/**',
            allowEmptyArchive: true
        )

        publishHTML(target: [
            reportDir: 'serenity-java/target/site/serenity',
            reportFiles: 'index.html',
            reportName: 'Reporte Serenity BDD',
            reportTitles: 'Resultados Serenity',
            keepAll: true,
            alwaysLinkToLastBuild: true,
            allowMissing: false
        ])

        publishHTML(target: [
            reportDir: 'playwright-python/reports',
            reportFiles: 'playwright-report.html',
            reportName: 'Reporte Playwright',
            reportTitles: 'Resultados Playwright',
            keepAll: true,
            alwaysLinkToLastBuild: true,
            allowMissing: true
        ])
    }
}