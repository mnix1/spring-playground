Stop retrying failing requests after some threshold has been reached. Return a fallback response.

1. Construct an instance of `io.github.resilience4j.circuitbreaker.CircuitBreaker`
   - use `io.github.resilience4j.circuitbreaker.CircuitBreaker.of`
   - use `io.github.resilience4j.circuitbreaker.CircuitBreakerConfig.custom`
   - set minimum number of calls to 10
2. Construct an instance of `io.github.resilience4j.retry.Retry`, as before
   - set max attempts to 20
   - set interval function to constant 1 ms (`io.github.resilience4j.core.IntervalFunction.of(long)`)
3. Define a fallback response as a function returning empty list
4. Decorate external api call with circuit breaker and retry
   - use `io.github.resilience4j.decorators.Decorators.ofCheckedSupplier`
   - call `.withCircuitBreaker(..).withRetry(..).decorate().recover(..).apply()`