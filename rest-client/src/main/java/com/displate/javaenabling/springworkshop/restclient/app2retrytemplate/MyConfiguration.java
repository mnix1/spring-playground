package com.displate.javaenabling.springworkshop.restclient.app2retrytemplate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Configuration
class MyConfiguration {

    @Bean
    MyService myService(@Value("${external.api.port}") long port) {
        return new MyService(createRetrofit(port).create(ExternalApi.class));
    }

    @Bean
    RetryTemplate createRetryTemplate() {
        RetryTemplate result = new RetryTemplate();
        result.setBackOffPolicy(new ExponentialBackOffPolicy());
        SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
        retryPolicy.setMaxAttempts(4);
        result.setRetryPolicy(retryPolicy);
        return result;
    }

    private Retrofit createRetrofit(long port) {
        return new Retrofit.Builder()
                .baseUrl("http://localhost:%s".formatted(port))
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }
}
