package com.displate.javaenabling.springworkshop.restclient.app3resilience4jretry;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Jacksonized
@Builder
public class UserDTO {
    String name;
}
