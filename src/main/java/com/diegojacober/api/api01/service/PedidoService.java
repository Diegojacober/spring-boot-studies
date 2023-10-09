package com.diegojacober.api.api01.service;

import com.diegojacober.api.api01.domain.entity.Pedido;
import com.diegojacober.api.api01.rest.controller.dto.PedidoDTO;

public interface PedidoService {
    Pedido salvar(PedidoDTO dto);
}
