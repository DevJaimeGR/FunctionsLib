def pushDockerImage(String DOCKER_CRED_USR, String DOCKER_CRED_PSW, String IMAGE_NAME, String VERSION, String REGISTRY) {
    sh "docker login --username=${DOCKER_CRED_USR} --password=${DOCKER_CRED_PSW}"
    sh "docker tag ${IMAGE_NAME}:${VERSION} ${REGISTRY}/${IMAGE_NAME}:${VERSION}"
    sh "docker push ${REGISTRY}/${IMAGE_NAME}:${VERSION}"
}

def buildImage(String IMAGE_NAME, String VERSION){
    sh "docker build -t ${IMAGE_NAME}:${VERSION} ."
}
