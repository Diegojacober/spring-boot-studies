package com.diegojacober.apilivros.rest.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diegojacober.apilivros.domain.entity.Author;

public interface AuthorService extends JpaRepository<Author, Long>{
    
}
