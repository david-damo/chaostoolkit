pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                // Checkout source code from the repository
                git branch: 'main'
                    url: 'https://github.com/david-damo/chaostoolkit.git'
                
                // Build the Maven project
                sh 'mvn clean package'
            }
          
        }
        
        stage('Test') {
            steps {
                // Run tests using Maven
                sh 'mvn test'
            }
            post {
                always {
                    // Publish JUnit test results
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
    }
}
