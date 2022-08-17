package com.displate.javaenabling.springworkshop.restclient.app3resilience4jretry;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Configuration
class MyConfiguration {

    @Bean
    MyService myService(@Value("${external.api.port}") long port) {
        return new MyService(createRetrofit(port).create(ExternalApi.class));
    }

    private Retrofit createRetrofit(long port) {
        return new Retrofit.Builder()
                .baseUrl("http://localhost:%s".formatted(port))
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }
}
