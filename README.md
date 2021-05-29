# Online-payment
> Challenge of Cuemby. This project was developed applying an architecture based on DDD, in which the core is completely separated from the main.

## Table of contents
* [Technologies](#technologies)
* [How it work](#how-work)
* [License](#license)
* [Contact](#contact)

## Technologies
* JDK - 15
* Spring boot - 2.4.5
* JUnit 5
* PostgreSQL - 13.1
* Docker

## How it Work
### **1. Environment variables**
* Clone the repository:
```bash
git clone https://github.com/
```
* Rename .env.example file to .env
* Edit APPLICATION_ROOT_FOLDER with the location where to clone the repository
* Edit MAVEN_SETTINGS_FOLDER with the location of the maven settings folder (.m2), if you don't have maven on your computer put any directory you want.
* If you are going to run the project with docker it is not necessary to change the database credentials, however if you already have a local db change the credentials.

### **3. Local. First, you need to install jdk and maven**

* Then open project folder and run:
```bash
mvn package
mvn spring-boot:run
```

* Then service run on http://localhost:8080/api/swagger-ui-html

### **2. Docker. First, you need to install docker**

* Download Docker [Here](https://docs.docker.com/docker-for-windows/install/). Hint: Enable Hyper-V feature if on windows and restart;
* Then open powershell and check:
```bash
docker info
```
or check docker version
```bash
docker -v
```
or docker compose version
```bash
docker-compose -v
```
### **2.1. Spring boot app**


* Running the containers:

This command will build the docker containers and start them.
```bash
docker-compose up
```
The first run can take a long time because you have to download the docker images and maven libraries.

* Then service run on http://localhost:8080/api/swagger-ui.html

## License
This project is licensed under the terms of the [MIT](https://choosealicense.com/licenses/mit/) license.
