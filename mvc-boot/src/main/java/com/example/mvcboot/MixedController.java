package com.example.mvcboot;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("mixed")
class MixedController {
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Map<String, Object> requestParams(@RequestParam("from") int from, @RequestParam(value = "to", required = false) Integer to) {
        Map<String, Object> map = new HashMap<>();
        map.put("from", from);
        map.put("to", to);
        return map;
    }

    //TODO https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-exceptionhandlers
    @GetMapping("not-found")
    void throwNotFoundException() {
        throw new NotFoundException();
    }

    @GetMapping("duplicate")
    void throwDuplicateException() {
        throw new DuplicateException();
    }

    @GetMapping("internal-server-error")
    void throwRuntimeException() {
        throw new RuntimeException();
    }

    @GetMapping("io-exception")
    void throwIOException() throws IOException {
        throw new IOException("io");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    static class NotFoundException extends RuntimeException {
        NotFoundException() {
            super("resource not found");
        }
    }

    static class DuplicateException extends RuntimeException {
        DuplicateException() {
            super("duplicate");
        }
    }

    @ExceptionHandler
    public ResponseEntity<String> handle(IOException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }
}
