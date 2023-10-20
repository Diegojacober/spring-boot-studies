package com.diegojacober.apilivros.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegojacober.apilivros.domain.entity.Author;
import com.diegojacober.apilivros.rest.repository.AuthorRepository;

@Service
public class AuthorService{
    
    @Autowired
    private AuthorRepository repository;

    public void saveAll(List<Author> authors) {
        repository.saveAll(authors);
    }

    public List<Author> findAll() {
        return repository.findAll();
    }
}
