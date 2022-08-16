package com.displate.javaenabling.springworkshop.restapi.util;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.context.annotation.Bean;

public class ActuatorHttpLoggerConfiguration {

    @Bean
    HttpTraceRepository httpTraceRepository() {
        return new LoggingHttpTraceRepository();
    }

}

@Slf4j
class LoggingHttpTraceRepository extends InMemoryHttpTraceRepository {
    @Override
    public void add(HttpTrace trace) {
        log.info("""
                        Got request:
                        {} {}
                        HEADERS {}
                        """,
                trace.getRequest().getMethod(),
                trace.getRequest().getUri(),
                trace.getRequest().getHeaders());
        super.add(trace);
    }
}