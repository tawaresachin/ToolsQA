pipeline
{
    agent any
    stages
    {
        stage ('Compile Stage')
        {
            withMaven(maven:'maven_3_8_2')
            steps
            {
                sh 'mvn clean compile'
            }
        }

        stage ('Test Stage')
                {
                    withMaven(maven:'maven_3_8_2')
                    steps
                    {
                       sh 'mvn clean test'
                    }
                }
    }
}