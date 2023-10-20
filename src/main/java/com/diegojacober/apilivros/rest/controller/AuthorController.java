package com.diegojacober.apilivros.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegojacober.apilivros.domain.entity.Author;
import com.diegojacober.apilivros.rest.service.AuthorService;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    
    @Autowired
    private AuthorService service;
    
    @GetMapping
    public List<Author> list() {
        return service.findAll();
    }
}
