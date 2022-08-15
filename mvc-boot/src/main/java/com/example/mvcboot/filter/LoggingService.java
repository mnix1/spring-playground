package com.example.mvcboot.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
class LoggingService {
    private final static Logger LOG = LoggerFactory.getLogger(LoggingService.class);

    void log(String message){
        LOG.info(message);
    }
}
