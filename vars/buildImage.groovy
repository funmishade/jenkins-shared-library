
def call () {
    echo "Building the Docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
        sh "docker build -t funmishade/demo-app:jma-2.0 ."
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh "docker push funmishade/demo-app:jma-2.0"
    }

}