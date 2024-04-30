pipeline {
    agent any

    tools {
      maven 'MAVEN_HOME'
      jdk 'JAVA_HOME'
    }

    environment {
        DOCKER_IMAGE = 'my-spring-boot-image'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build Docker image') {
            steps {
                sh 'mvn spring-boot:build-image -Dspring-boot.build-image.imageName=$DOCKER_IMAGE'
            }
        }

        stage('Verify Docker image') {
            steps {
                script {
                    def img = docker.image("$DOCKER_IMAGE")
                    img.pull()
                    img.run('java -version')
                }
            }
        }
    }
}