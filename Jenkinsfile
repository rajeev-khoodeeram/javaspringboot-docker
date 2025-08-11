pipeline {
    agent any
    tools {
        maven 'Rajeev-maven'  // name you gave in Global Tool Config
    }
 

    environment {
        PATH = "/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin"
        DOCKER_HUB_CREDENTIALS = credentials('docker-hub-credentials-id')
        IMAGE_NAME = 'rajeevmauritius/myapp'
        IMAGE_TAG = "${env.BUILD_NUMBER}"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'feature/initial-project', url: 'https://github.com/rajeev-khoodeeram/JavaFullStack.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'  // Build without tests here
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'                      // Run tests separately
                junit 'target/surefire-reports/*.xml'  // Publish test results
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    sh 'docker build -t ${IMAGE_NAME}:${IMAGE_TAG} .'
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', 'docker-hub-credentials-id') {
                        sh 'docker push ${IMAGE_NAME}:${IMAGE_TAG}'
                    }
                }
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploy step - add your deployment script here (e.g., ssh, kubectl, docker run)'
            }
        }
    }

    post {
        always {
            cleanWs()  // Clean workspace after build
        }
        success {
            echo 'CI/CD Pipeline succeeded!'
        }
        failure {
            echo 'CI/CD Pipeline failed!'
        }
    }
}


