package com.angela.apidummy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ApidummyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApidummyApplication.class, args);
	}

}
