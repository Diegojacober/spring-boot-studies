package com.diegojacober.api.api01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiApplication {

	@Bean
	public CommandLineRunner init() {
		return args -> {

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
