### Build Application
    mvn clean install

### Run the application
    mvn spring-boot:run

#### Create or store hospital
    curl --location --request POST 'http://localhost:8080/save/hospital' \
    --header 'Content-Type: application/json' \
    --data-raw '{
                    "hospital_name":"hospital1",
                    "address":"Bangalore",
                    "id":101
            }'

#### Read Hospital data
    curl --location --request GET 'http://localhost:8080/get/hospital?hospital_name=hospital1'

#### Update Hospital details

    curl --location --request PUT 'http://localhost:8080/update/hospital?hospital_name=hospital1&address=Delhi'

#### delete Hospital details
    curl --location --request DELETE 'http://localhost:8080/delete/hospital?hospital_name=hospital1'

#### Create or store Patient
    curl --location --request POST 'http://localhost:8080/save/patient' \
    --header 'Content-Type: application/json' \
    --data-raw '{
                    "patient_name":"patient1",
                    "id":"1"
                    "hospital_name":"hospital1",
                    "disease":"Dengue fever"
            }'

#### Read Patient data
    curl --location --request GET 'http://localhost:8080/get/patient?patient_name=patient1'

#### Update Patient details

    curl --location --request PUT 'http://localhost:8080/update/hospital?patient_name=patient1&hospital_name=hospital2'

#### Delete Patient details
    curl --location --request DELETE 'http://localhost:8080/delete/hospital?patient_name=patient1'