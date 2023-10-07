package com.diegojacober.api.api01.domain.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diegojacober.api.api01.domain.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
    
}
