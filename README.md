# spring-security-jwt

# Generate jwt:

curl -X POST \
  http://localhost:9090/authenticate \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: eaf22062-9397-4e44-8d3d-a00e6ded28c2' \
  -H 'cache-control: no-cache' \
  -d '{ "username" : "foo", "password" : "foo" }'


# Test endpoint with security jwt:

Firts must change the key in the header Bearer

curl -X GET \
  http://localhost:9090/test \
  -H 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJmb28iLCJleHAiOjE1NzgzMTE4NzAsImlhdCI6MTU3ODI3NTg3MH0.kwq5u7q5Wc-bbaIu23f2yyFNlj-S1XevJX6ceunaRHM' \
  -H 'Connection: keep-alive' \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 98c5e5f3-2895-47ff-9213-78114a6f1c1b' \
  -H 'cache-control: no-cache'
