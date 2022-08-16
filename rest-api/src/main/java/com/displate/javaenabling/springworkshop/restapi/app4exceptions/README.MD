Add an exception handler to return HTTP 400 for `RuntimeException`

Use 
- `@org.springframework.web.bind.annotation.ControllerAdvice`
- `org.springframework.web.bind.annotation.ExceptionHandler`
- `ResponseEntityExceptionHandler` (inherit)
- `handleExceptionInternal` (inherited from handler)