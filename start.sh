docker network create jenkins_network
docker volume create jenkins-docker-certs
docker volume create jenkins-data

docker image pull docker:dind

#In order to execute Docker commands inside Jenkins nodes, download and run the docker:dind Docker image
docker run \
  --name jenkins-docker \
  --detach --privileged \
  --network jenkins_network \
  --network-alias docker \
  --env DOCKER_TLS_CERTDIR=/certs \
  --volume jenkins-docker-certs:/certs/client \
  --volume jenkins-data:/var/jenkins_home \
  --publish 2376:2376 \
  docker:dind

#Download the jenkinsci/blueocean
docker container run --name jenkins-blueocean --detach \
  --network jenkins_network --env DOCKER_HOST=tcp://docker:2376 \
  --env DOCKER_CERT_PATH=/certs/client --env DOCKER_TLS_VERIFY=1 \
  --volume jenkins-data:/var/jenkins_home \
  --volume jenkins-docker-certs:/certs/client:ro \
  --publish 8090:8080 --publish 50000:50000 jenkinsci/blueocean

sudo docker exec jenkins-blueocean cat /var/jenkins_home/secrets/initialAdminPassword

docker container stop jenkins-docker
docker container start jenkins-docker