pipeline {
    agent any
    // add this tools section in case Jenkins cannot find maven (you will get message
    // could not find mvn in the console output)
    tools {
        maven 'Rajeev-maven'  // name you gave in Global Tool Config
    }
 

    environment {
        PATH = "/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin"
        DOCKER_HUB_CREDENTIALS = credentials('docker-hub-credentials-id')
        IMAGE_NAME = 'rajeevmauritius/myapp' //name of image that will appear on dockerhub
        IMAGE_TAG = "jenkins-${env.BUILD_NUMBER}"
    }

    stages {
        stage('Checkout') {
            steps {
                //  normally you will branch into main
                //  but since I was using a git repository that was  a branch
                //  I replaced main with the branch name
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
                // DOCKER_HUB_CREDENTIALS_USR and DOCKER_HUB_CREDENTIALS_PSW are environment variables
                // that have been set on 127.0.0.1:8080
                sh """
                    echo ${DOCKER_HUB_CREDENTIALS_PSW} | docker login -u ${DOCKER_HUB_CREDENTIALS_USR} --password-stdin
                    docker push ${IMAGE_NAME}:${IMAGE_TAG}
                    docker logout
                  """
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


