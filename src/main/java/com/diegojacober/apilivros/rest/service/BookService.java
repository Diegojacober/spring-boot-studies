package com.diegojacober.apilivros.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.diegojacober.apilivros.domain.entity.Book;
import com.diegojacober.apilivros.rest.repository.BookRepository;

@Service
public class BookService{

    @Autowired
    private BookRepository repository;

    public Page<Book> findAllByCriteria(Page pageable) {
        return repository.findAll(pageable);
    }
}
