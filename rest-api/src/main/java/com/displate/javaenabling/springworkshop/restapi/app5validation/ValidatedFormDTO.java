package com.displate.javaenabling.springworkshop.restapi.app5validation;

import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
class ValidatedFormDTO {
    @NotBlank
    String userName;

    String country;
}

