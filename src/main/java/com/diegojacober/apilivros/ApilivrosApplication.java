package com.diegojacober.apilivros;

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

	@Autowired
	private AuthorService authorService;

	@Autowired BookService bookService;

	@Override
	public void run(String... args) throws Exception {
		List<Author> authors = new ArrayList<>(Arrays.asList(new Author(null, "Diego"), new Author(null, "Fernando Pessoa")));
		authorService.saveAll(authors);
	}

	public static void main(String[] args) {
		SpringApplication.run(ApilivrosApplication.class, args);
	}

}
