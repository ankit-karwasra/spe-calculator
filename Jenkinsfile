pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {

        stage('Clone Repo') {
            steps {
                git branch: 'main', url: 'https://github.com/kartik-2011/ScientificCalculator-DevOps.git'
        }
        }

        stage('Build this Project') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Build the Docker Image') {
            steps {
                sh 'docker build -t kaali2011/scientific-calculator .'
            }
        }

        stage('Push Docker Image') {
            steps {
                sh 'docker push kaali2011/scientific-calculator'
            }
        }

        stage('Deploy with Ansible') {
            steps {
                sh 'ansible-playbook -i hosts deploy.yml'
            }
        }

    }
    post {
    success {
        mail to: 'kartikahluwalia2011@gmail.com',
        subject: 'Build Success',
        body: 'The Jenkins build was successful.'
    }
    failure {
        mail to: 'kartikahluwalia2011@gmail.com',
        subject: 'Build Failed',
        body: 'The Jenkins build has failed.'
    }
}
}