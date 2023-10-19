package com.diegojacober.apilivros.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diegojacober.apilivros.domain.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
    
}
