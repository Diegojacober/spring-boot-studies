package com.diegojacober.api.api01;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.diegojacober.api.api01.domain.entity.Cliente;
import com.diegojacober.api.api01.domain.entity.Produto;
import com.diegojacober.api.api01.domain.entity.repository.ClienteRepository;
import com.diegojacober.api.api01.domain.entity.repository.ProdutoRepository;

@SpringBootApplication
public class ApiApplication {

	@Bean
	public CommandLineRunner init(@Autowired ClienteRepository clienteRepository, @Autowired ProdutoRepository produtoRepository) {
		return args -> {
			clienteRepository.save(new Cliente(null, "Diego Alencar", "50352627077"));
			produtoRepository.save(new Produto(null, "Carro", BigDecimal.valueOf(150000.00)));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
