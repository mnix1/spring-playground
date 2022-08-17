Retry failed calls with exponential backoff using resilience4j


1. In `MyService`, Construct an instance of `io.github.resilience4j.retry.Retry`
   - use `io.github.resilience4j.retry.Retry.of`
   - use `io.github.resilience4j.retry.RetryConfig.custom`
   - set max attempts to 4
   - set interval function to exponential backoff
2. call `executeCheckedSupplier` on the constructed retry to wrap `doGetUsers` in retry