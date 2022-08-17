package com.displate.javaenabling.springworkshop.restclient.app2retrytemplate;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.support.RetryTemplate;
import retrofit2.Response;

import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
class MyService {
    ExternalApi externalApi;

    List<UserDTO> getUsers() throws Exception {
        return doGetUsers();
    }

    private List<UserDTO> doGetUsers() throws Exception {
        log.info("Getting users");
        Response<List<UserDTO>> response = externalApi.getUsers().execute();
        if(!response.isSuccessful())
            throw new RuntimeException(String.format("Error - can't get users %s", response.code()));
        return response.body();
    }
}
