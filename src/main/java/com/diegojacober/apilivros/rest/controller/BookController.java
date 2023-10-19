package com.diegojacober.apilivros.rest.controller;

import com.diegojacober.apilivros.domain.entity.Book;
import com.diegojacober.apilivros.rest.service.BookService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/book")
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping
    public Page<Book> list(Pageable page) {
        return service.findAll(page);
    }
}