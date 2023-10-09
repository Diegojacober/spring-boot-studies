package com.diegojacober.api.api01.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegojacober.api.api01.domain.entity.Cliente;
import com.diegojacober.api.api01.domain.entity.ItemPedido;
import com.diegojacober.api.api01.domain.entity.Pedido;
import com.diegojacober.api.api01.domain.entity.Produto;
import com.diegojacober.api.api01.domain.entity.enums.StatusPedido;
import com.diegojacober.api.api01.domain.entity.repository.ClienteRepository;
import com.diegojacober.api.api01.domain.entity.repository.ItemPedidoRepository;
import com.diegojacober.api.api01.domain.entity.repository.PedidoRepository;
import com.diegojacober.api.api01.domain.entity.repository.ProdutoRepository;
import com.diegojacober.api.api01.exception.PedidoNaoEncontradoException;
import com.diegojacober.api.api01.exception.RegraNegocioException;
import com.diegojacober.api.api01.rest.controller.dto.ItemPedidoDTO;
import com.diegojacober.api.api01.rest.controller.dto.PedidoDTO;
import com.diegojacober.api.api01.service.PedidoService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;

    private final ClienteRepository clienteRepository;

    private final ProdutoRepository produtoRepository;

    private final ItemPedidoRepository itemPedidoRepository;

    @Override
    @Transactional // ou faz tudo ou se der erro cancela tudo
    public Pedido salvar(PedidoDTO dto) {
        Integer idCliente = dto.getCliente();
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RegraNegocioException("Código de cliente inválido"));
        Pedido pedido = new Pedido();
        pedido.setTotal(dto.getTotal());
        pedido.setDataPedido(LocalDate.now());

        pedido.setCliente(cliente);
        pedido.setStatus(StatusPedido.REALIZADO);

        List<ItemPedido> itemsPedido = converterItens(pedido, dto.getItems());
        pedidoRepository.save(pedido);
        itemPedidoRepository.saveAll(itemsPedido);
        pedido.setItens(itemsPedido);
        return pedido;
    }

    private List<ItemPedido> converterItens(Pedido pedido, List<ItemPedidoDTO> items) {
        if (items.isEmpty()) {
            throw new RegraNegocioException("Não é possível realizar um pedido sem items.");
        }

        return items
                .stream()
                .map(dto -> {
                    Integer idProduto = dto.getProduto();
                    Produto produto = produtoRepository
                            .findById(idProduto)
                            .orElseThrow(
                                    () -> new RegraNegocioException(
                                            "Código de produto inválido: " + idProduto));

                    ItemPedido itemPedido = new ItemPedido();
                    itemPedido.setQuantidade(dto.getQuantidade());
                    itemPedido.setPedido(pedido);
                    itemPedido.setProduto(produto);
                    return itemPedido;
                }).collect(Collectors.toList());
    }

    @Override
    public Optional<Pedido> obterPedidoCompleto(Integer id) {
        return pedidoRepository.findByIdFetchItens(id);
    }

    @Override
    @Transactional
    public void atualizarStatus(Integer id, StatusPedido status) {
        pedidoRepository.findById(id).map(pedido -> {
            pedido.setStatus(status);
            return pedidoRepository.save(pedido);
        }).orElseThrow(() -> new PedidoNaoEncontradoException("Código de produto inválido"));
    }

}
