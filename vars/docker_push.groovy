def call (String dockerHubUser, String Project, String ImageTag){
  withCredentials(["usernamePassword"('credentialsId':"dockerHubCred",passwordVariable:"dockerHubPass",UsernameVariable:"dockerHubUser")])
  sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
  sh "docker push ${dockeHubUser}/${Project}:${ImageTag}"
}
