pipeline {
    agent any
    environment {
        // Define the password credential ID
        PASSWORD_CREDENTIAL = 'sanjeev'
    }
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
            }
        }
        stage('Install Python') 
        {
            steps 
            {
            	//withCredentials([string(credentialsId: env.PASSWORD_CREDENTIAL, variable: 'PASSWORD')]) {
                    // Run the command with sudo and pass the password
                    //sh "echo $PASSWORD | sudo -S apt update"
                    //sh "echo $PASSWORD | sudo -S apt install -y python3 python3-pip"
                    //}
                sh '''
                    echo "sanjeev | sudo -S apt update"
                    echo "sanjeev | sudo -S apt install -y python3 python3-pip"
                    echo "sanjeev | sudo -S apt install python3.10-venv"
                    
                '''
                //sh 'apt update'
                //sh 'apt install -y python3 python3-pip'
            }
        }
        
        stage('Create Virtual Environment') 
        {
            steps 
            {
                script 
                {
                	//sleep(time: 180, unit: 'SECONDS')
                	sh '''
                    echo "sanjeev | sudo -S python3 -m venv myenv"
                    
                '''
                    //sh 'python3 -m venv myenv'
                }
            }
        }
        
        stage('Activate Virtual Environment') 
        {
            steps 
            {
                script 
                {
                    //sh 'source myenv/bin/activate'
                    sh '''
                    echo "sanjeev | sudo -S source myenv/bin/activate"
                    
                '''
                }
            }
        }
        
        stage('Install ChaosToolkit') 
        {
            steps 
            {
                script 
                {
                    //sh 'pip install chaostoolkit'
                    sh '''
                    echo "sanjeev | sudo -S apt install python3-pip"
                    echo "sanjeev | sudo -S pip install chaostoolkit"
                    
                '''
                }
            }
        }
        stage('Install ChaosToolkitForSpring') 
        {
            steps 
            {
                script 
                {
                	//sh 'pip install chaostoolkit-spring'
                	sh '''
                	pwd
                	ls
                    echo "sanjeev | sudo -S pip install chaostoolkit-spring"
                    '''
                }
            }
        }
        stage('Run Chaos Script') {
        when { expression { return fileExists ('/var/lib/jenkins/workspace/chaos toolkit/experiments/experiment2.json') } }
            steps {
                //sh ". /chaostoolkit/.venvs/chaostk/bin/activate && chaos run experiments/experiment2.json"
                
                sh "chaos run /var/lib/jenkins/workspace/chaos toolkit/experiments/experiment2.json"
                //sh '''
	            //    cd experiments
	            //    pwd
	            //    ls
	            //    echo "sanjeev | sudo -S chaos run /var/lib/jenkins/workspace/chaos toolkit/experiments/experiment2.json"   
                //'''
            }

            post {
                success {
                    echo 'Success'
                }
            }
        }
        
    }
}

