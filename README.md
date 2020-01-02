# spring-security-jwt

Generate jwt:

curl -X POST \
  http://localhost:9090/authenticate \
  -H 'Accept: */*' \
  -H 'Accept-Encoding: gzip, deflate' \
  -H 'Cache-Control: no-cache' \
  -H 'Connection: keep-alive' \
  -H 'Content-Length: 44' \
  -H 'Content-Type: application/json' \
  -H 'Cookie: JSESSIONID=85960BA5B863BC0F972C94CDA0FA6A47' \
  -H 'Host: localhost:9090' \
  -H 'Postman-Token: 086a78b5-b122-4092-82b8-f140ddb50a3b,35ef94cf-1937-4cc2-a3ec-0fbf29362edd' \
  -H 'User-Agent: PostmanRuntime/7.20.1' \
  -H 'cache-control: no-cache' \
  -d '{
	"username" : "foo",
	"password" : "foo"
}'


Test endpoint with security jwt:


curl -X GET \
  http://localhost:9090/test \
  -H 'Accept: */*' \
  -H 'Accept-Encoding: gzip, deflate' \
  -H 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJmb28iLCJleHAiOjE1Nzc4MDA1NzMsImlhdCI6MTU3Nzc2NDU3M30.Y4lEhgRE0w7xVKYeH4vA5tM-JhBRP33Y65FmO78XDSs' \
  -H 'Cache-Control: no-cache' \
  -H 'Connection: keep-alive' \
  -H 'Content-Type: application/json' \
  -H 'Cookie: JSESSIONID=85960BA5B863BC0F972C94CDA0FA6A47' \
  -H 'Host: localhost:9090' \
  -H 'Postman-Token: 2cd8a495-1cfb-45b0-a7ce-ff346ed7b0aa,19ab646c-3279-4f3b-a69b-fca7c83b68da' \
  -H 'User-Agent: PostmanRuntime/7.20.1' \
  -H 'cache-control: no-cache'
