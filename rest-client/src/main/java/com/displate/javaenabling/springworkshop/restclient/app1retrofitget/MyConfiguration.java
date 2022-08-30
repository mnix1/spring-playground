package com.displate.javaenabling.springworkshop.restclient.app1retrofitget;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Configuration
class MyConfiguration {

    @Bean
    MyService myService(@Value("${external.api.port}") long port) {
        Retrofit retrofit = getRetrofit(port);

        return new MyService(retrofit.create(ExternalApi.class));
    }

    @NotNull
    private Retrofit getRetrofit(long port) {
        return new Retrofit.Builder()
                .baseUrl("http://localhost:%s".formatted(port))
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }


}
