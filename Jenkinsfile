pipeline {
    agent any
    stages 
    {
        stage('Build') 
        {
           steps 
           {
	           // Checkout source code from the repository
	           git branch: 'main',
	           url: 'https://github.com/david-damo/chaostoolkit.git'
	                
	           // Build the Maven project
	           sh 'mvn clean package'
           }
          
        }
        
        stage('Test') 
        {
            steps 
            {
                // Run tests using Maven
                sh 'mvn test'
            }
            post 
            {
                always 
                {
                    // Publish JUnit test results
                    junit 'target/surefire-reports/*.xml'
                }
                success 
                {
                    emailext 
                    (
                        to: 'sanjeev.jha77@gmail.com',
                        subject: 'Pipeline Success Notification',
                        body: 'Your pipeline has succeeded. Good job!',
                    )
                }
                failure 
                {
                    emailext 
                    (
                        to: 'sanjeev.jha77@gmail.com',
                        subject: 'Pipeline Failure Notification',
                        body: 'Your pipeline has failed. Please check the logs for details.',
                    )
                }
            }
        }
        stage('Install Python') 
        {
            steps 
            {
                sh 'apt update'
                sh 'apt install -y python3 python3-pip'
            }
        }
        
        stage('Create Virtual Environment') 
        {
            steps 
            {
                script 
                {
                    sh 'python3 -m venv myenv'
                }
            }
        }
        
        stage('Activate Virtual Environment') 
        {
            steps 
            {
                script 
                {
                    sh 'source myenv/bin/activate'
                }
            }
        }
        
        stage('Install ChaosToolkit') 
        {
            steps 
            {
                script 
                {
                    sh 'pip install chaostoolkit'
                }
            }
        }
        stage('Install ChaosToolkitForSpring') 
        {
            steps 
            {
                script 
                {
                    sh 'pip install chaostoolkit-spring'
                }
            }
        }
        stage('Run Chaos Script') {
            steps {

                sh ". /chaostoolkit/.venvs/chaostk/bin/activate && chaos run SimpleExperiment.json"
            }

            post {
                success {
                    echo 'Success'
                }
            }
        }
        
    }
}
