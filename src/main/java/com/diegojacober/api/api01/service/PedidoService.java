package com.diegojacober.api.api01.service;

import java.util.Optional;

import com.diegojacober.api.api01.domain.entity.Pedido;
import com.diegojacober.api.api01.rest.controller.dto.PedidoDTO;

public interface PedidoService {
    Pedido salvar(PedidoDTO dto);

    Optional<Pedido> obterPedidoCompleto(Integer id);
}
