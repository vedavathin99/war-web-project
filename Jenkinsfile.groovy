node 
{
	    stage('checkout') 
            {
                    git branch: 'master', url: 'https://github.com/Yashwinrajs/tomcat-project.git'
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
                    sh 'sudo cp /home/ec2-user/workspace/demo-Tomcat/target/TomcatMavenApp-2.0.war /home/ec2-user/tomcat/webapps'
            }
    }
}
