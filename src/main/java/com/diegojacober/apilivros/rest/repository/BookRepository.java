package com.diegojacober.apilivros.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.diegojacober.apilivros.domain.entity.Author;
import com.diegojacober.apilivros.domain.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>, JpaSpecificationExecutor<Book>{
    List<Book> findByAuthor(Author author);
}
