Hospital Detials

'''
SAVE
curl --location --request POST 'http://localhost:8081/hospital/save' \
--header 'Content-Type: application/json' \
--data-raw '{
"hospitalname":"hospital1",
"address":"bangalore"
}'

GET
curl --location --request GET 'http://localhost:8081/hospital/get'

DELETE
curl --location --request DELETE 'http://localhost:8081/hospital/delete?id=1'
'''


Patient Details

'''
SAVE

curl --location --request POST 'http://localhost:8081/patient/save' \
--header 'Content-Type: application/json' \
--data-raw '{
"patientname":"patient1",
"hospitalname":"hospital1",
"disease":"dengue fever"
}'

GET

curl --location --request GET 'http://localhost:8081/patient/get'
DELETE

curl --location --request DELETE 'http://localhost:8081/patient/delete?id=3'