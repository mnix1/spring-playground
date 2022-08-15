package com.example.mvcboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(assignableTypes = {ViewController.class, MixedController.class})
class ExampleAdvice {
    @ExceptionHandler(MixedController.DuplicateException.class)
    public ResponseEntity<String> handle(MixedController.DuplicateException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }
}
/*
// Target all Controllers annotated with @RestController
@ControllerAdvice(annotations = RestController.class)
public class ExampleAdvice1 {}

// Target all Controllers within specific packages
@ControllerAdvice("org.example.controllers")
public class ExampleAdvice2 {}

// Target all Controllers assignable to specific classes
@ControllerAdvice(assignableTypes = {ControllerInterface.class, AbstractController.class})
public class ExampleAdvice3 {}
 */
