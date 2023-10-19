package com.diegojacober.apilivros.rest.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.diegojacober.apilivros.domain.entity.Book;

@Service
public interface BookService extends JpaRepository<Book, Long>{
    
}
