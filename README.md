# bootstrap
Run `./gradlew dockerUp`, it will
* clean
* run tests with testcontainers
* build spring boot jar and place it into docker image `wtf.small/bootstrap:<version>`
* run application with docker-compose

To stop use `docker-compose down`.
It will stop application and will remove containers, networks and images
