Since version 4.0, mongodb supports multi-document transactions. Spring-data-mongo also
supports it.

There are two ways to wrap your code in transactions:

- low-level api with `ClientSession`
- high-level api with `MongoTemplate` and `TransactionTemplate`

# Low level approach

As in `app1session`, use `MongoClient` to obtain a session (you might customize session
settings). Then, with the session you can operate on low-level api on the db collections.

Make sure that session is closed after the transaction (use try-with-resources block).

This approach makes it difficult to separate persistence logic
from domain logic. It offers fine grained control over the transaction settings, but is hard
to read.

# High level, functional approach

Use `TransactionTemplate` wrapper to make any `MongoOperations` calls run in transaction.

For it to work, `MongoTransactionManager` bean must be defined:

```java
    @Bean
    MongoTransactionManager mongoTransactionManager(MongoDatabaseFactory dbFactory){
            return new MongoTransactionManager(dbFactory);
            }
```

You might customize the transaction manager with read/write concern. It's not possible to
declare causal consistency with this approach though.

This'll allow

# Watch out for @Transactional annotation 

It doesn't seem to work with spring data mongo. The service is not wrapped in a proxy
as it should, therefore no transaction takes place.

Even if it did work, it's an inferior approach, as it's unpredictable and won't work as expected
in numerous cases. Programmatic approach is the safest