Retry failed calls with exponential backoff using spring retry template


1. Add `org.springframework.retry.support.RetryTemplate` as a dependency to `MyService`
2. Wrap the retrofit call in `retryTemplate.execute`
3. In `MyConfiguration`, construct an instance of `RetryTemplate`. Use:
   - `org.springframework.retry.backoff.ExponentialBackOffPolicy`
   - `org.springframework.retry.policy.SimpleRetryPolicy` with 4 max attempts