// package com.example

// class Docker implements Serializable {
//     def script

//     Docker(script) {
//         this.script = script
//     }

//     def buildDockerImage(String imageName) {
//         script.echo "Building the Docker image..."
//         script.sh "docker build -t ${imageName} ."
        
//          {
//             script.sh "docker build -t ${imageName} ."
//             script.sh "echo '${script.PASS}' | docker login -u '${script.USER}' --password-stdin"
//             script.sh "docker push ${imageName}"
//         }
//     }

//     def dockerLogin() {
//         script.withCredentials([
//             script.usernamePassword(
//                 credentialsId: 'dockerhub',
//                 usernameVariable: 'USER',
//                 passwordVariable: 'PASS'
//             )
//         ]) {
//             script.sh "echo '${script.PASS}' | docker login -u '${script.USER}' --password-stdin"
//         }
//     }

//     def dockerPush(String imageName) {
//         script.sh "docker push ${imageName}"
//     }
// }


package com.example

class Docker implements Serializable {
    def script

    Docker(script) {
        this.script = script
    }

    def buildDockerImage(String imageName) {
        script.echo "Building the Docker image..."
        script.sh "docker build -t ${imageName} ."
    }

    def dockerLogin() {
        script.withCredentials([
            script.usernamePassword(
                credentialsId: 'dockerhub',
                usernameVariable: 'USER',
                passwordVariable: 'PASS'
            )
        ]) {
            script.sh '''
                echo "$PASS" | docker login -u "$USER" --password-stdin
            '''
        }
    }

    def dockerPush(String imageName) {
        script.sh "docker push ${imageName}"
    }
}