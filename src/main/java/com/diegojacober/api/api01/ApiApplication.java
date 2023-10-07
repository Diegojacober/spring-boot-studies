package com.diegojacober.api.api01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.diegojacober.api.api01.domain.entity.Cliente;
import com.diegojacober.api.api01.domain.entity.repository.ClienteRepository;

@SpringBootApplication
public class ApiApplication {

	@Bean
	public CommandLineRunner init(@Autowired ClienteRepository clienteRepository) {
		return args -> {
			clienteRepository.save(new Cliente(null, "Diego Alencar"));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
