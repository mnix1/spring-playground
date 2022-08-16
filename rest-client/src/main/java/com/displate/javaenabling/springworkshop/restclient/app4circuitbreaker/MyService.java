package com.displate.javaenabling.springworkshop.restclient.app4circuitbreaker;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.core.IntervalFunction;
import io.github.resilience4j.decorators.Decorators;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import retrofit2.Response;

import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
class MyService {
    ExternalApi externalApi;

    List<UserDTO> getUsers() throws Throwable {

        return Decorators.ofCheckedSupplier(this::doGetUsers)
                .withCircuitBreaker(circuitBreaker())
                .withRetry(retry())
                .decorate()
                .recover(it -> this::fallbackResponse)
                .apply();

    }

    private CircuitBreaker circuitBreaker() {
        return CircuitBreaker.of("externalApi", CircuitBreakerConfig.custom()
                .minimumNumberOfCalls(10)
                .build());
    }

    private Retry retry() {
        return Retry.of("externalApi", RetryConfig.custom()
                .maxAttempts(20)
                .intervalFunction(IntervalFunction.of(1))
                .build());
    }

    private List<UserDTO> doGetUsers() throws Exception {
        log.info("Getting users");
        Response<List<UserDTO>> response = externalApi.getUsers().execute();
        if (!response.isSuccessful())
            throw new RuntimeException(String.format("Error - can't get users %s", response.code()));
        return response.body();
    }

    private List<UserDTO> fallbackResponse() {
        return List.of();
    }
}
