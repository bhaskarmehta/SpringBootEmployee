pipeline {
    agent any

    tools {
        maven "MAVEN"
        jdk "JDK"
    }

    parameters {
        choice(name: 'DEPLOYMENT_VERSION', choices: ['blue', 'green'], description: 'Choose the deployment version to deploy')
    }

    environment {
        REGISTRYURL = 'bhasmeht'
        AWS_REGION = 'us-east-1'
        EKS_CLUSTER_NAME = 'mycluster'
        KUBECONFIG_PATH = '/tmp/kubeconfig'
    }

    stages {
        stage('Initialize') {
            steps {
                echo "PATH = ${M2_HOME}/bin:${PATH}"
                echo "M2_HOME = /opt/maven"
            }
        }
        
        stage('Build') {
            steps {
                withCredentials([string(credentialsId: 'DOCKER_REGISTRY_PASS', variable: 'DOCKER_REGISTRY_PASS')]) {
                    sh 'docker login -u bhasmeht -p "${DOCKER_REGISTRY_PASS}"'
                    sh 'mvn -B -DskipTests clean package'
                    sh 'docker build -t $REGISTRYURL/java-app:1.2 . '
                    sh 'docker push $REGISTRYURL/java-app:1.2'
                }
            }
        }

        stage('Unit Test'){
            steps{
                echo "Unit Testing is done"
            }
        }

        stage('Sonarqube Analysis'){
            steps{
                echo "Sonarqube is done"
            }
        }

        stage('Sonarqube QG'){
            steps{
                echo "Sonarqube QG is done"
            }
        }

        stage('Configure Kubectl') {
            steps {
                withCredentials([file(credentialsId: 'eks-kubeconfig', variable: 'KUBECONFIG')]) {
                    sh 'cp $KUBECONFIG /tmp/kubeconfig'

                    withEnv(["KUBECONFIG=${KUBECONFIG_PATH}"]) {
                        sh 'aws eks update-kubeconfig --region us-east-1 --name mycluster'
                        sh 'kubectl get nodes'
                    }
                }
            }
        }

        stage('Deploy to EKS') {
            steps {
                script {
                    if (params.DEPLOYMENT_VERSION == 'blue') {
                        echo 'Deploying Blue Version'
                        sh 'kubectl apply -f Deployment/BlueDeployments'
                    } else if (params.DEPLOYMENT_VERSION == 'green') {
                        echo 'Deploying Green Version'
                        sh 'kubectl apply -f Deployment/GreenDeployments'
                    }
                }
            }
        }
    }
}




// pipeline {
//     agent any
    
//     tools {
//         maven "MAVEN" 
//         jdk "JDK" 
//     }
    
//     environment {
//         // Define environment variables for GKE configuration
//         REGISTRYURL = 'bhasmeht'
//         AWS_REGION = 'us-east-1'
//         EKS_CLUSTER_NAME = 'mycluster'
//         // GKE_PROJECT_ID = 's-0-000240-02'
//         // GKE_CLUSTER_NAME = 'krishidss-k8s-staging'
//         // GKE_CLUSTER_ZONE = 'asia-south1-a'
//         // GKE_CLUSTER_REGION = 'asia-south1'
//         // GKE_NAMESPACE = 'krishidss'
//         KUBECONFIG_PATH = '/tmp/kubeconfig'
//         //GKE_CREDENTIAL_ID = 'gke'
//     }
    
//     stages {
//         stage('Initialize'){
//             steps {
//                 echo "PATH = ${M2_HOME}/bin:${PATH}"
//                 echo "M2_HOME = /opt/maven"
//             }
//         } 

//         stage('Build') { 
//             steps {
//                 withCredentials([string(credentialsId: 'DOCKER_REGISTRY_PASS', variable: 'DOCKER_REGISTRY_PASS')]) {
//                      sh 'docker login -u bhasmeht -p "${DOCKER_REGISTRY_PASS}"'
//                      sh 'mvn -B -DskipTests clean package'
//                      sh 'docker build -t $REGISTRYURL/java-app:1.2 . '
//                      sh 'docker push $REGISTRYURL/java-app:1.2'
//                 }
//             }
//         }
//         stage('Configure Kubectl') {
//             steps {
//                 withCredentials([file(credentialsId: 'eks-kubeconfig', variable: 'KUBECONFIG')]) {
//                     sh 'cp $KUBECONFIG /tmp/kubeconfig'
                    
//                     withEnv(["KUBECONFIG=${KUBECONFIG_PATH}"]) {
//                         sh 'kubectl get nodes'
//                     }
//                 }
//             }
//         }
//         stage('Deploy to EKS') {
//             steps {
//                 withEnv(["KUBECONFIG=${KUBECONFIG_PATH}"]) {
//                     sh 'kubectl apply -f Deployment'
//                 }
//             }
//         }
//     }
// }