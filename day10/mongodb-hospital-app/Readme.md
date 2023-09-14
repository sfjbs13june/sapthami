## Build the app

``` 
mvn clean install
```

## Run the app

``` 
docker-compose -f docker-compose-mongo.yml up -d
mvn spring-boot:run

```
## Creating docker image

```
mvn install dockerfile:build

```
## running docker compose

``` 
docker-compose up -d

```


## Post

``` 
curl --location --request POST 'http://localhost:8082/hospital/save' \
--header 'Content-Type: application/json' \
--data-raw '{
    "hospitalname":"hospital1",
    "address":"bangalore"
}'



curl --location --request POST 'http://localhost:8082/patient/save' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id":"1",
    "patienname":"patient1",
    "hospitalname":"hospital1",
    "disease":"dengue"
}'
```

## Get

``` 
curl --location --request GET 'http://localhost:8082/hospital/get'

curl --location --request GET 'http://localhost:8082/patient/get'

```

## Put

``` 
 curl --location --request PUT 'http://localhost:8082/hospital/save' \
--header 'Content-Type: application/json' \
--data-raw '{
    "hospitalname":"hospital1",
    "address":"Pune"
}'
```

## Delete

```
curl --location --request DELETE 'http://localhost:8082/hospital/delete?id=0'

curl --location --request DELETE 'http://localhost:8082/patient/delete?pid=0'
```




## Show data

```
docker exec -it mongodb-hospital-app-mongo-1 bash

mongo

show dbs

show tables

db.customer.find()

```

## Stop docker container
    docker-compose -f docker-compose-mongo.yml down

## Dockerization

### Maven
Here i am using maven spotify plugin to create the docker image for this application.
Use the below command to create the docker image.
For creating please use your repository to create the image which will be easy to push image in your docker hub.
update in your pom.xml.
<docker.image.prefix> <your repo name> </docker.image.prefix>

```bash
$ mvn install dockerfile:build
```

### Push docker images

```bash
docker login

$ docker push <repository-name>/<app-name>

```

