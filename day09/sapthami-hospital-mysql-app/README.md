Hospital Detials

'''
SAVE 
curl --location --request POST 'http://localhost:8081/hospital/save' \
--header 'Content-Type: application/json' \
--data-raw '{"hospital_name":"rama","address":"bangalore"}'

GET
curl --location --request GET 'http://localhost:8081/hospital/get'

DELETE
curl --location --request DELETE 'http://localhost:8081/hospital/delete?id=2'
'''


Patient Details

'''
SAVE

curl --location --request POST 'http://localhost:8081/patient/save' \
--header 'Content-Type: application/json' \
--data-raw '{"patient_name":"sham",hospital_name":"rama","disease":"dengue fever"}'

GET

curl --location --request GET 'http://localhost:8081/patient/get'

DELETE

curl --location --request DELETE 'http://localhost:8081/patient/delete?p_id=1'