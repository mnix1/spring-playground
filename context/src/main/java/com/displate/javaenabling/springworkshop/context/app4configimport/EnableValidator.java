package com.displate.javaenabling.springworkshop.context.app4configimport;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Import({ValidatorConfiguration.class})
@Retention(RetentionPolicy.RUNTIME)
@interface EnableValidator {
}
