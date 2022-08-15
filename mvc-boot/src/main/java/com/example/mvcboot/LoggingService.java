package com.example.mvcboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoggingService {
    private final static Logger LOG = LoggerFactory.getLogger(LoggingService.class);

    public void log(String message){
        LOG.info(message);
    }
}
