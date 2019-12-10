pipeline {
    agent any
    tools {
        maven 'Maven'
        jdk 'JDK 1.8'
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    curl "https://api.github.com/repos/<afsanchezsa>/labs-backend/statuses/$GIT_COMMIT?access_token=<a4fedb80b442b3fd4fea9afb73f06b39b18e41c4>" \
                      -H "Content-Type: application/json" \
                      -X POST \
                      -d "{\"state\": \"pending\",\"context\": \"continuous-integration/jenkins\", \"description\": \"Jenkins\", \"target_url\": \"$BUILD_URL\"}"
                '''
                sh '''
                    echo "PATH = ${PATH}"
                '''
            }
        }
        stage ('Build') {
            steps {
                sh 'mvn clean install package spring-boot:repackage'
            }
        }
    }
    post{
        always{
            sh '''
                curl "https://api.github.com/repos/afsanchezsa/labs-backend/statuses/$GIT_COMMIT?access_token=a4fedb80b442b3fd4fea9afb73f06b39b18e41c4" \
                  -H "Content-Type: application/json" \
                  -X POST \
                  -d "{\"state\": \"$BUILD_STATUS\",\"context\": \"continuous-integration/jenkins\", \"description\": \"Jenkins\", \"target_url\": \"$BUILD_URL\"}"
            '''
        }
    }

}

