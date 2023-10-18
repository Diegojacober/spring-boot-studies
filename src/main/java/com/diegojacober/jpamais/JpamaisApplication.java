package com.diegojacober.jpamais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.diegojacober.jpamais.domain.repository.CidadeRepository;


@SpringBootApplication
public class JpamaisApplication implements CommandLineRunner{

	@Autowired
	private CidadeRepository cidadeRepository;

	@Override
	public void run(String... args) throws Exception {
		listarCidades();
	}

	void listarCidades() {
		cidadeRepository.findAll().forEach(System.out::println);
	}

	void listarCidadesPorHabitantes() {
		cidadeRepository.findByHabitantes(999999L);
	}

	void listarCidadesPorNome() {
		cidadeRepository.findByNome("Campinas");
	}

	public static void main(String[] args) {
		SpringApplication.run(JpamaisApplication.class, args);
	}

}
