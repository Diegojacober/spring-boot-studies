package com.diegojacober.apilivros.rest.controller;

import com.diegojacober.apilivros.domain.entity.Book;
import com.diegojacober.apilivros.rest.repository.criterias.BookCriteria;
import com.diegojacober.apilivros.rest.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping
    public Page<Book> list(BookCriteria criteria, Pageable page) {
        return service.findAllByCriteria(criteria, page);
    }

    @GetMapping("/teste")
    public String test() {
        return "test";
    }
}
