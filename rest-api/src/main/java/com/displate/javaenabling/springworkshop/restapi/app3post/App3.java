package com.displate.javaenabling.springworkshop.restapi.app3post;

import com.displate.javaenabling.springworkshop.restapi.util.ActuatorHttpLoggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({ActuatorHttpLoggerConfiguration.class})
public class App3 {

	public static void main(String[] args) {
		SpringApplication.run(App3.class, args);
	}

}
