Accept `POST /form` with form in body. In response, return HTTP 201. 
Return the last sent form in `GET /last-form`

## Controller


Accept `POST /form` with form in body. In response, return HTTP 201. Use
- `@org.springframework.web.bind.annotation.PostMapping`
- `@org.springframework.web.bind.annotation.ResponseStatus`
- `@org.springframework.web.bind.annotation.RequestBody`

## Tests:
Two approaches - with 
- `org.springframework.boot.test.web.client.TestRestTemplate` and
- `org.springframework.test.web.servlet.MockMvc`

### TestRestTemplate
1. With implicit serialization/deserialization
    1. Use `restClient.postForEntity` with `FormDTO` object as body. It will be serialized to json internally
    2. Assert that the response status is 201
    3. Use `restClient.getForEntity`
    4. Assert response status 200
    5. Assert body same as in the post request above
2. Post JSON as string
   Same as above, but in the post body send a json representation of the FormDTO. Also set the content-type to
    `application/json`. Use:
    - `org.springframework.http.HttpEntity`
    - `org.springframework.http.HttpHeaders`
    - `httpHeaders.setContentType`

### MockMvc
Mock mvc allows to assert received json without deserialization.



