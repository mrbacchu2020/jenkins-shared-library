def call(Map config) {

pipeline {

    agent { label 'docker' }

    stages {

        stage('Checkout') {
            steps {
                git config.repo
            }
        }

        stage('Build') {
            steps {
                sh "docker build -t ${config.image} ."
            }
        }

        stage('Test') {
            steps {
                echo "Running tests..."
            }
        }

        stage('Scan') {
            steps {
                echo "Security scanning..."
            }
        }

        stage('Deploy') {
            steps {
                echo "Deploying application..."
            }
        }

    }

}
}
