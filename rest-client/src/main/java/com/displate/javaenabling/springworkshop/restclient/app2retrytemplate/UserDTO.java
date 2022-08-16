package com.displate.javaenabling.springworkshop.restclient.app2retrytemplate;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Jacksonized
@Builder
public class UserDTO {
    String name;
}
