Spring allows to specify persistence declaratively.

All you have to do is:

- mark your document class with `@org.springframework.data.mongodb.core.mapping.Document` annotation,
- mark the id property of the class with `@org.springframework.data.annotation.Id`
- declare an interface, that extends `org.springframework.data.repository.CrudRepository`

And you're good to go. Spring will automatically provide an implementation to your interface and
allow you to persist it with methods declared in the `CrudRepository`. Dynamic code generation
(via `CGLIB`) is used to make this work.

You can also declare your own methods using
special [notation](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repository-query-keywords
):

1. `Optional<MyDocument> findBySomeValue(BigDecimal someValue);`

   Implementation will search the collection for a document with `someValue` property set to the
   given parameter. If it's found, it will be wrapped in an Optional and returned. Otherwise,
   `Optional.empty()` is returned
2. `List<MyDocument> findBySomeObjectsText(String text);`

   Implementation will search the collection for document, that have a list of `SomeObject`,
   that contains an object with `text` property equal to given argument. All found documents
   will be returned.

Although it might be handy to let spring implement your methods for you, it has some shortcomings:

- no ability to use Mongo atomic operations, such as `findAndModify`
- no support for transactions