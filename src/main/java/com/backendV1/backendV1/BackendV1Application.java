package com.backendV1.backendV1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude =SecurityAutoConfiguration.class )
public class BackendV1Application {

	public static void main(String[] args) {
		SpringApplication.run(BackendV1Application.class, args);
	}

}
//http://localhost:8088/h2-console