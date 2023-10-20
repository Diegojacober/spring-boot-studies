package com.diegojacober.apilivros.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.diegojacober.apilivros.domain.entity.Book;
import com.diegojacober.apilivros.rest.repository.BookRepository;
import com.diegojacober.apilivros.rest.repository.specs.CriteriaSpecification;


@Service
public class BookService{

    @Autowired
    private BookRepository repository;

    public List<Book> findAll() {
        return repository.findAll();
    }

    public Page<Book> findAllByCriteria(CriteriaSpecification<Book> criteria ,Pageable pageable) {
        var specification = criteria.toSpecification();
        return repository.findAll(specification, pageable);
    }

    public void save(Book book) {
        repository.save(book);
    }
}
