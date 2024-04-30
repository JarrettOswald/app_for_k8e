pipeline {
    agent any

    tools {
        maven '3.6.3'
        dockerTool 'latest'
    }

    environment {
        DOCKER_IMAGE = 'jarrettoswald/my-spring-boot-image:latest'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('mvn clean package') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $DOCKER_IMAGE .'
            }
        }

        stage('Docker Push') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                    sh '''
                      docker login -u $USERNAME -p $PASSWORD
                      docker push $DOCKER_IMAGE
                    '''
                }
            }
        }
    }
}