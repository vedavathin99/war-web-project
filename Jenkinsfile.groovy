node 
{
	    stage('checkout') 
            {
                    git branch: 'master', url: ''https://github.com/vedavathin99/war-web-project.git'
            }

            stage('Build') 
            {
                    sh 'mvn clean package'
            }
            stage('Post') 
            {
                    echo "This is post stage"
            }
        
            stage('Deploy') 
            {
                    sh 'sudo cp /home/ec2-user/tomcat/workspace/pipeline-1/target/wwp-1.0.0.war /home/ec2-user/apache-tomcat-9.0.84/webapps'
            }
    }
}
