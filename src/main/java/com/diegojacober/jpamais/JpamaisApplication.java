package com.diegojacober.jpamais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.diegojacober.jpamais.domain.entity.Cidade;
import com.diegojacober.jpamais.service.CidadeService;


@SpringBootApplication
public class JpamaisApplication implements CommandLineRunner{

	@Autowired
	private CidadeService cidadeService;

	@Override
	public void run(String... args) throws Exception {
		cidadeService.listarCidades();
		// cidadeService.listarCidadesByNomeSpecs();
		cidadeService.listarCidadeSpecsFiltroDinamico(new Cidade(null, "São Paulo", 123L));
		// cidadeService.listarCidadesPorNome();
		// cidadeService.listarCidadesPorHabitantes();
		// cidadeService.filtroDinamico(new Cidade(null, "Cor", 48L)).forEach(System.out::println);;
	}

	public static void main(String[] args) {
		SpringApplication.run(JpamaisApplication.class, args);
	}

}
