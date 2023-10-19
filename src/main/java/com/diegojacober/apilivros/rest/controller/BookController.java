package com.diegojacober.apilivros.rest.controller;

import com.diegojacober.apilivros.domain.entity.Book;
import com.diegojacober.apilivros.rest.service.BookService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/book")
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping
    public List<Book> list() {
        return service.findAll();
    }
}
