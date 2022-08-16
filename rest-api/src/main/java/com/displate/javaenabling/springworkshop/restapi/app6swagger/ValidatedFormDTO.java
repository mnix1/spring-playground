package com.displate.javaenabling.springworkshop.restapi.app6swagger;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
class ValidatedFormDTO {
    @NotBlank
    String userName;

    @Size(min = 3, max = 40)
    String country;
}

