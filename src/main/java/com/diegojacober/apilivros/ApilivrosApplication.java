package com.diegojacober.apilivros;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.diegojacober.apilivros.domain.entity.Author;
import com.diegojacober.apilivros.rest.service.AuthorService;
import com.diegojacober.apilivros.rest.service.BookService;

@SpringBootApplication
public class ApilivrosApplication implements CommandLineRunner{
	// https://maykonoliveira850.medium.com/listagem-com-filtragem-din%C3%A2mica-e-pagina%C3%A7%C3%A3o-usando-o-spring-boot-2b99dd1d7050
	@Autowired
	private AuthorService authorService;

	@Autowired BookService bookService;

	@Override
	public void run(String... args) throws Exception {
		Author autor1 = new Author(null, "Diego");
		Author autor2 = new Author(null, "Fernando Pessoa");
		Author autor3 = new Author(null, "Marcos Gente");
		List<Author> authors = new ArrayList<>(Arrays.asList(autor1, autor2, autor3));
		authorService.saveAll(authors);
	}

	public static void main(String[] args) {
		SpringApplication.run(ApilivrosApplication.class, args);
	}

}
