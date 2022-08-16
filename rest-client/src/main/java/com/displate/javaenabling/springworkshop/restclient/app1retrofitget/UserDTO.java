package com.displate.javaenabling.springworkshop.restclient.app1retrofitget;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Jacksonized
@Builder
public class UserDTO {
    String name;
}
