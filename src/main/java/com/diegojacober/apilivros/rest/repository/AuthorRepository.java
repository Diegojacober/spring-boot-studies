package com.diegojacober.apilivros.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diegojacober.apilivros.domain.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer>{
    
}
