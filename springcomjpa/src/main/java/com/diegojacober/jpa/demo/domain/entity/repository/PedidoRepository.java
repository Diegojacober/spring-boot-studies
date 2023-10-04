package com.diegojacober.jpa.demo.domain.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diegojacober.jpa.demo.domain.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
    
}
