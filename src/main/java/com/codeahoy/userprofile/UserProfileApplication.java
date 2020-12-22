package com.codeahoy.userprofile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserProfileApplication {
	private static final Logger logger = LoggerFactory.getLogger(UserProfileApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(UserProfileApplication.class, args);
		logger.info("Please visit http://localhost:8085/api/v1/users/umer@codeahoy.com which should return the new " +
				"algorithm");
	}
}
