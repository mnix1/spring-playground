Add a simple rest controller to handle HTTP GET /stuff. Return a String "actual stuff"

Create a spring boot test with random server port.

Use `@org.springframework.boot.test.web.server.LocalServerPort` to inject actual server port

Inject `@org.springframework.boot.test.web.client.TestRestTemplate` to get a http client for tests

Call `getForEntity` with `String` result type and `/stuff` path.

Assert status 200 and body "actual stuff"

For implementation, use `@org.springframework.web.bind.annotation.RestController` and
`@org.springframework.web.bind.annotation.GetMapping`

