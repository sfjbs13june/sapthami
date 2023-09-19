# Project
This Application is use understand the basic security mechanism in spring boot application.

## Import project
Import the project on either eclipse or inellij as a maven import project

## Building

### Maven
This project is maven project which will be build using maven command.

```bash
$ mvn clean install
```

### Running (Make sure that eureka server is up)
This project is maven project which will be run using maven command.

```bash
$ mvn spring-boot:run
```

### Test

```bash
$ curl --location --request GET 'http://localhost:9092/getHospitalDetails/Hospital1'
```