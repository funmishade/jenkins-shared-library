
// def call () {
//     echo "Building the Docker image..."
//     withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
//         sh "docker build -t funmishade/demo-app:jma-2.0 ."
//         sh "echo $PASS | docker login -u $USER --password-stdin"
//         sh "docker push funmishade/demo-app:jma-2.0"
//     }

// }



def call (string imageName) {
    echo "Building the Docker image..."
    withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
        sh "docker build -t $imageName ."
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh "docker push $imageName"
    }

}