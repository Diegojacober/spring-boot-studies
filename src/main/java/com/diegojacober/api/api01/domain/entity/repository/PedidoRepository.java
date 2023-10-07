package com.diegojacober.api.api01.domain.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diegojacober.api.api01.domain.entity.Cliente;
import com.diegojacober.api.api01.domain.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
    List<Pedido> findByCliente(Cliente cliente);
}
