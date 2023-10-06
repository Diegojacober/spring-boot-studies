package com.diegojacober.jpa.demo.domain.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diegojacober.jpa.demo.domain.entity.Cliente;
import com.diegojacober.jpa.demo.domain.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
    List<Pedido> findByCliente(Cliente cliente);
}
