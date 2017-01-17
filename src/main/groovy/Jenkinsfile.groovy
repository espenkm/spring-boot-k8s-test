node {
  stage('Checkout code'){
    checkout scm
  }
  stage('Download latest helm'){
    def helmObject = 'helm-v2.1.3-linux-amd64.tar'
    def helmUrl = "https://storage.googleapis.com/kubernetes-charts-ci/helm/${helmObject}"
    sh "wget -q ${helmUrl}"
    sh "tar xfv ${helmObject}"
  }
  stage('Install helm'){
    sh './linux-amd64/helm init'
    return 0
  }
  stage('build'){
    
  }
}
