Use retrofit to easily communicate with other services via REST API calls

### define external API

1. Create a new interface `ExternalApi`
2. Create a method `getUsers` in `ExternalApi`. Let it return `retrofit2.Call` of `List<UserDTO>`
3. Annotate with `@retrofit2.http.GET("users")`

###

1. Declare `ExternalApi` as a dependency to `MyService`
2. In `MyConfiguration`, construct an instance of `retrofit2.Retrofit`.
3. Set the baseUrl to `http://localhost:<port>`
4. Inject the port with `@org.springframework.beans.factory.annotation.Value("${external.api.port}")`
5. add `retrofit2.converter.jackson.JacksonConverterFactory` as a converter factory to retrofit
6. Using `Retrofit`, build an instance of `ExternalApi`, pass it to `MyService`
7. In `MyService` in method `getUsers` call `execute().body()` to return the body 