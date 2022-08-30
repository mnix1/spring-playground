To optimize your queries, indices should be used.

Mongo comes with two types of index:

- Regular index
- Compound index

The regular one is based on a single property, while the compound index might consist of several
properties, with the sort order provided separately for each property.

# Annotation indices creation

To declare an index, use `@Indexed` annotation over the document property.

To declare a compound index, use `@CompoundIndexes` with nested `@CompoundIndex` annotations
over the document class.

For performance reasons, it's best to always configure your indices to be created in the
background (use annotation parameter for that.)

By default, automatic index creation is disabled in spring-data-mongo. To enable it,
declare a property in property file:
`spring.data.mongodb.auto-index-creation=true`

# Programatic indices creation

Indices can be defined programatically as
well: https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#mapping.index-creation
