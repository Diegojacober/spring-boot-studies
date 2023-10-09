package com.diegojacober.api.api01.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegojacober.api.api01.domain.entity.repository.PedidoRepository;
import com.diegojacober.api.api01.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService{
    
    @Autowired
    private PedidoRepository pedidoRepository;
}
