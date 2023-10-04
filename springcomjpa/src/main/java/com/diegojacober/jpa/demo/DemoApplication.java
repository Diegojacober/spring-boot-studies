package com.diegojacober.jpa.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.diegojacober.jpa.demo.domain.entity.Cliente;
import com.diegojacober.jpa.demo.domain.entity.repository.ClienteRepository;

@SpringBootApplication
public class DemoApplication {

	@Bean
	public CommandLineRunner init(@Autowired ClienteRepository clienteRepository) {
		return args -> {
			clienteRepository.salvar(new Cliente(null, "Pedro"));
			clienteRepository.salvar(new Cliente(null, "Henrique"));

			List<Cliente> todosClientes = clienteRepository.obterTodos();
			todosClientes.forEach(System.out::println);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
