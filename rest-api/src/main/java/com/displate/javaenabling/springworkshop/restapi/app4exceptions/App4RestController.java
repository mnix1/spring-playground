package com.displate.javaenabling.springworkshop.restapi.app4exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
class App4RestController {

    @GetMapping("/bad-request")
    String getBadRequest() {
        throw new RuntimeException("Something wrong");
    }
}

@ControllerAdvice
class MyExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(
            value = {RuntimeException.class}
    )
    ResponseEntity<Object> handleRuntimeException(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(), HttpHeaders.EMPTY, HttpStatus.BAD_REQUEST, request);
    }
}