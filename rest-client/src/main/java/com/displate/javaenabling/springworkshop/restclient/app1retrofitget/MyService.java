package com.displate.javaenabling.springworkshop.restclient.app1retrofitget;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
class MyService {
    List<UserDTO> getUsers() {
        throw new RuntimeException("TODO");
    }
}
