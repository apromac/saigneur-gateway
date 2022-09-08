pipeline {
    agent any
    tools {
        maven "Maven386"
    }

    stages {
        stage('Build') {
            steps {
                echo '--------------------< Compilation du code source >--------------------'
                sh 'mvn -B -DskipTests clean package'
            }
            post {
                success {
                    // we only worry about archiving the jar file if the build steps are successful
                    archiveArtifacts(artifacts: '**/target/*.jar', allowEmptyArchive: true)
                }
            }
        }

        stage('Build and start container') {
            steps {
                echo '--------------------< Compilation du docker-compose >--------------------'
                sh 'docker compose build'

                echo '--------------------< Lancement du docker-compose (containers) >--------------------'
                sh 'docker compose up -d'

                echo '--------------------< Affichage des containers actifs >--------------------'
                sh 'docker ps'
            }
        }
    }
}


// pipeline {
//     agent any
//     environment {
//         DOCKER_IMAGE_NAME = "saigneur-gateway-web"
//         BUILD_TAG = "v1.0.${BUILD_NUMBER}"
//         CONTAINER_NAME = "msaigneur-gateway-web"
//         CONTAINER_PORT = 9001
//         IMAGE_DEFAULT_DIR = "/usr/local/microservice/msaigneur"
//         VOLUME_NAME = "postgres_data"
//     }
//     stages {
//         stage('Build') {
//             steps {
//                 echo 'Compilation du code source ...'
//                 sh '/usr/local/maven386/bin/mvn -version'
//                 sh '/usr/local/maven386/bin/mvn clean install -DskipTests'
//             }
//         }
//     }
// }
