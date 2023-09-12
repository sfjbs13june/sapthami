```
##POST

curl --location --request POST 'http://localhost:8081/user/create' \
--header 'Content-Type: application/json' \
--data-raw '{"name": "Rama","teamName": "beta","salary": 23000 }'

##GET
curl --location --request GET 'http://localhost:8081/user/read'

##DELETE
curl --location --request DELETE 'http://localhost:8081/user/delete?id=2'

'''