#!/user/bin/env groovy 
// def call() {
//     echo 'Building the application...'
//     sh 'mvn package'

// }

def call() {
    echo "Building the application for branch $GIT_BRANCH..."
    sh 'mvn package'

}