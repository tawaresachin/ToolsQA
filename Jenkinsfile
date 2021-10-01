pipeline
{
    agent any
    stages
    {
        stage ('Compile Stage')
        {

            steps
            {
                withMaven(maven:'maven_3_8_2')
                {
                bat '/mvn clean compile/'
                }
            }
        }

        stage ('Test Stage')
                {
                    steps
                    {
                        withMaven(maven:'maven_3_8_2')
                        {
                            bat '/mvn clean test/'
                        }
                    }
                }
    }
}