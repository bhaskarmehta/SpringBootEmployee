pipeline {
    agent any
    
    tools {
        maven "MAVEN" 
        jdk "JDK" 
    }
    
    environment {
        // Define environment variables for GKE configuration
        REGISTRYURL = 'bhasmeht'
        // GKE_PROJECT_ID = 's-0-000240-02'
        // GKE_CLUSTER_NAME = 'krishidss-k8s-staging'
        // GKE_CLUSTER_ZONE = 'asia-south1-a'
        // GKE_CLUSTER_REGION = 'asia-south1'
        // GKE_NAMESPACE = 'krishidss'
        // HELM_CHART_NAME = 'crop-analytics'
        // HELM_RELEASE_NAME = 'crop-analytics'
        //GKE_CREDENTIAL_ID = 'gke'
    }
    
    stages {
        stage('Initialize'){
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
                     sh 'docker build -t $REGISTRYURL/java-app:1.1 . '
                     sh 'docker push $REGISTRYURL/java-app:1.1'
                }
                
                
            }
        }

        // stage('Deploy') {
        //     steps {
        //         // Authenticate with Google Cloud using service account key
        //         withCredentials([file(credentialsId: 'GKE_KEYS', variable: 'GKE_KEYS')]) {
        //             sh 'gcloud auth activate-service-account --key-file=$GKE_KEYS'

        //             // setting the project
        //             sh 'gcloud config set project $GKE_PROJECT_ID'

        //             // Configure kubectl to use credentials for GKE cluster
        //             sh 'gcloud container clusters get-credentials $GKE_CLUSTER_NAME --region $GKE_CLUSTER_REGION --project $GKE_PROJECT_ID'

        //             // Delete existing application to GKE cluster using helm
        //             sh "helm delete $HELM_RELEASE_NAME --namespace $GKE_NAMESPACE"
                
        //             // Deploy application to GKE cluster using Helm
        //             sh "helm install $HELM_RELEASE_NAME ./$HELM_CHART_NAME --namespace $GKE_NAMESPACE"


        //             // // Running kubectl command for kustomization
        //             // sh "kubectl apply -k k8s-kustomize/patches/staging  --namespace $GKE_NAMESPACE"
        //         }                             
        //     }
        // }
    }
}