def call(String Project, String ImageTag, String dockerHubUser){
  withCredentials([usernamePassword(credentialsId:'dockerHubCred',PasswordVariable:'dockerHubPass',UsernameVariable:'dockerHubUser'){
    sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
  }
    sh "docker push ${dockerHubUser}/${Project}:${ImageTag}"
}
