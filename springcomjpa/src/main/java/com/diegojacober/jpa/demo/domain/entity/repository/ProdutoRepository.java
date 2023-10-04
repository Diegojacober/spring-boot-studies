package com.diegojacober.jpa.demo.domain.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diegojacober.jpa.demo.domain.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
    
}
