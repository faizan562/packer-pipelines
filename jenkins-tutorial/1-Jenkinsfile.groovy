pipeline {
  agent any

  stages {
    stage('Packer - Build Docker Image') {
      steps {
        sh """
        #!/bin/bash
        cd jenkins-tutorial
        sudo packer init .
        sudo packer build -force .
        """
      }
    }
    stage('Docker - Verify Docker Image') {
      steps {
        sh """
        #!/bin/bash
        sudo docker images
        """
      }
    }
  }
}
