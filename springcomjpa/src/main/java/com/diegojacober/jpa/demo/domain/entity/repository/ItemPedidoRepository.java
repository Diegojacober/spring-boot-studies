package com.diegojacober.jpa.demo.domain.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diegojacober.jpa.demo.domain.entity.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer>{
    
}
