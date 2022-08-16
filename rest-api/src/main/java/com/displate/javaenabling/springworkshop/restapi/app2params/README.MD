Create a rest controller with URI prefix `/app2` (use `@org.springframework.web.bind.annotation.RequestMapping` on
class)

Create three endpoints (`@org.springframework.web.bind.annotation.GetMapping`) to handle requests:

1. `GET /app2/path-param/{user}`

   should return the `user` path variable (use `@org.springframework.web.bind.annotation.PathVariable`)


2. `GET /app2/request-param `

   should return the `user` request param (use `org.springframework.web.bind.annotation.RequestParam`)


3. `GET /app2/header `

   should return the value of `X-USER` header (use `@org.springframework.web.bind.annotation.RequestHeader`)

Use `@org.springframework.web.bind.annotation.RequestMapping` on class to only specify `/app2` prefix once.