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
            	sh '''
                    echo "sanjeev | sudo -S apt update"
                    echo "sanjeev | sudo -S apt install python3-pip"

                    echo "sanjeev | sudo -S pip3 install virtualenv"
                    virtualenv myenv
                    
                '''
                
            }
        }
        
        stage('Create Virtual Environment') 
        {
            steps 
            {
                script 
                {
                	sh '''
                    echo "create Virtual Environment....."
                    
                '''
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
                    cd myenv/bin
                    ls
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
                //sh ". myenv/bin/activate && chaos run experiments/experiment2.json"
                sh '''
                cd myenv
                ls
                cd bin
                ls
                cd ..
                cd ..
                sh '''
                sh "chaos run experiments/experiment2.json"
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

