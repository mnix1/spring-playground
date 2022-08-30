package com.displate.javaenabling.springworkshop.restclient.app1retrofitget;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
class MyService {
    ExternalApi externalApi;

    List<UserDTO> getUsers() throws IOException {
        return externalApi.getUsers().execute().body();
    }
}
