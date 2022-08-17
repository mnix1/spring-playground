Create a repository with Drake already added and inject it 
to test spring context to make the test pass.

In test, create a configuration class (doesn't have to be annotated)
and import it with `@SpringBootTest`

Override the UserRepository with `@org.springframework.context.annotation.Primary`
