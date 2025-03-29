def call(String credId,String imageId){
  
                withCredentials([usernamePassword(
                    credentialsId:"${credId}",
                    passwordVariable:"dockerHubPass",
                    usernameVariable:"dockerHubUser",
                    )]){
                        sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
                        sh "docker image tag ${env.dockerHubUser}/${imageId}"
                        sh "docker push ${env.dockerHubUser}/${imageId}"
                    }
                }
