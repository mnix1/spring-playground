package com.displate.javaenabling.springworkshop.restclient.app1retrofitget;

import org.springframework.context.annotation.Configuration;

@Configuration
class MyConfiguration {

    MyService myService(long port) {
        return new MyService();
    }
}
