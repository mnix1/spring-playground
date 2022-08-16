Create a custom annotation for triggering bean creation.
Use `@org.springframework.context.annotation.Import` to make the annotation import
ValidatorConfiguration. Use `@java.lang.annotation.Retention` to set
the retention to runtime for spring to be able to find it.

Annotate MyConfiguration with the new, custom annotation.