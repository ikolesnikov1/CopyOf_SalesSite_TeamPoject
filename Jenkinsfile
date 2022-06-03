pipeline {
    agent any

    tools {
        jdk 'jdk1.8'
        nodejs 'node1'
    }

    stages {
        stage('Build'){
            parallel {
                stage('Build backend') {
                    environment {
                        mvn = tool 'maven1'
                    }

                    steps {
                            sh "${mvn}/bin/mvn package"
                    }
                }

                stage('Build frontend') {
                    steps {
                        dir("src/main/webapp/reactjs") {
                            script {
                                sh "npm install"
                                sh "CI=false npm run build"
                            }
                        }
                    }
                }

                stage('Login in registry') {
                    steps {
                        withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'password', usernameVariable: 'user')]) {
                            sh "docker login -u ${env.user} -p ${env.password}"
                        }
                    }
                }
            }
        }

        stage('Images') {
            parallel {
                stage('Build backend image') {
                    steps {
                        sh "docker build . -t memph11s/sales-backend:${env.BUILD_NUMBER}"
                        sh "docker push memph11s/sales-backend:${env.BUILD_NUMBER}"
                    }
                }

                stage('Build frontend image') {
                    steps {
                        dir("src/main/webapp/reactjs") {
                            sh "docker build . -t memph11s/sales-frontend:${env.BUILD_NUMBER}"
                        }
                        sh "docker push memph11s/sales-frontend:${env.BUILD_NUMBER}"
                    }
                }
            }
        }

        stage('Deploy to k8s') {
            steps {
                withCredentials([file(credentialsId: 'kubeconfig', variable: 'CONFIG')]) {
					sh "kubectl apply -f k8s-manifests/ingress.yaml --kubeconfig=\"$CONFIG\""
                    sh "kubectl set image deployment/sales-backend sales-backend=memph11s/sales-backend:${env.BUILD_NUMBER} --kubeconfig=\"$CONFIG\""
                    sh "kubectl set image deployment/sales-frontend sales-frontend=memph11s/sales-frontend:${env.BUILD_NUMBER} --kubeconfig=\"$CONFIG\""
                }
            }
        }

        stage('SonarQube Analysis') {
            environment {
                sonar = tool 'sonarqube-4.7.0'
            }

            steps {
                withSonarQubeEnv(installationName: 'SonarQube', credentialsId: 'sonar-token') {
                    sh "${sonar}/bin/sonar-scanner"
                }
            }
        }
    }
    post {
        failure {
            updateGitlabCommitStatus name: 'pipeline', state: 'failed'
        }
        success {
            updateGitlabCommitStatus name: 'pipeline', state: 'success'
        }
        aborted {
           updateGitlabCommitStatus name: 'pipeline', state: 'canceled'
        }
    }
}

