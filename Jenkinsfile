pipeline
{
    node any
    stages
    {
        stage 'Compile Stage'
        {
            withMaven(maven_3_8_2)
            {
                sh 'mvn clean compile'
            }
        }

        stage 'Test Stage'
                {
                    withMaven(maven_3_8_2)
                    {
                       sh 'mvn clean test'
                    }
                }
    }
}