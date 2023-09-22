package com.secao01.secao01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
//Nõa é muito utilizado, só quando é uma configuração externa, fora do pacote principal
//@ComponentScan(basePackages = {"com.secao01.secao01.Repositories", "com.secao01.secao01.Services"}) //Escanear classes, configurações, tudo necessário para a aplicação
@RestController
public class Secao01Application {

	// @Autowired
	// @Qualifier("applicationName") // Pega essa configuração do sistema
	@Value("${application.name}")
	private String applicationName;

	@GetMapping("/hello")
	public String helloWorld() {
		return applicationName;
	}

	public static void main(String[] args) {
		SpringApplication.run(Secao01Application.class, args);
	}

}
