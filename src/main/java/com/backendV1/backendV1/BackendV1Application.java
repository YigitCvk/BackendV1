package com.backendV1.backendV1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.backendV1.backendV1.business.abstracts.UserService;
import com.backendV1.backendV1.dataAccess.UserCreateDTO;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class BackendV1Application {

	public static void main(String[] args) {
		SpringApplication.run(BackendV1Application.class, args);
	}

	@Bean
	CommandLineRunner createInitialUsers(UserService userService) {
		return (args) -> {
			UserCreateDTO user = new UserCreateDTO();
			user.setUserName("User1");
			user.setFirstName("Mehmet1");
			user.setLastName("Pekdemir1");

			userService.createUser(user);

			UserCreateDTO user2 = new UserCreateDTO();
			user2.setUserName("User2");
			user2.setFirstName("Mehmet2");
			user2.setLastName("Pekdemir2");

			userService.createUser(user2);

			UserCreateDTO user3 = new UserCreateDTO();
			user3.setUserName("User3");
			user3.setFirstName("Mehmet3");
			user3.setLastName("Pekdemir3");

			userService.createUser(user3);
		};
	}
}
//http://localhost:8088/h2-console