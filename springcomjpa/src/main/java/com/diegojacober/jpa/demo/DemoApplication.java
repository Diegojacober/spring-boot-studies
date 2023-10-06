package com.diegojacober.jpa.demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.diegojacober.jpa.demo.domain.entity.Cliente;
import com.diegojacober.jpa.demo.domain.entity.ItemPedido;
import com.diegojacober.jpa.demo.domain.entity.Pedido;
import com.diegojacober.jpa.demo.domain.entity.repository.ClienteRepository;
import com.diegojacober.jpa.demo.domain.entity.repository.PedidoRepository;

@SpringBootApplication
public class DemoApplication {

	@Bean
	public CommandLineRunner init(@Autowired ClienteRepository clienteRepository,
			@Autowired PedidoRepository pedidoRepository) {
		return args -> {
			// clienteRepository.salvar(new Cliente(null, "Pedro"));
			clienteRepository.save(new Cliente(null, "Pedro"));
			// clienteRepository.salvar(new Cliente(null, "Henrique"));
			clienteRepository.save(new Cliente(null, "Henrique"));

			// List<Cliente> todosClientes = clienteRepository.obterTodos();
			List<Cliente> todosClientes = clienteRepository.findAll();
			todosClientes.forEach(System.out::println);

			todosClientes.forEach(c -> {
				c.setNome(c.getNome().concat(" Atualizado"));
				// clienteRepository.atualizar(c);
				clienteRepository.save(c);
				System.out.println("Atualizado para: " + c);
			});

			System.out.println("Buscando clientes");
			// clienteRepository.buscarPorNome("Pe").forEach(System.out::println);
			clienteRepository.encontrarPorNome("Pe").forEach(System.out::println);

			Cliente clienteP = new Cliente(null, "Cliente");
			clienteRepository.save(clienteP);
			Pedido p = new Pedido();
			p.setCliente(clienteP);
			p.setDataPedido(LocalDate.now());
			p.setTotal(BigDecimal.valueOf(10.0));
			p.setItens(null);
			pedidoRepository.save(p);

			//Cliente cliente = clienteRepository.findClienteFetchPedidos(clienteP.getId());
			//System.out.println(cliente);
			//System.out.println(cliente.getPedidos());

			pedidoRepository.findByCliente(clienteP).forEach(System.out::println);
			/*
			 * todosClientes = clienteRepository.findAll();
			 * todosClientes.forEach(c -> {
			 * clienteRepository.delete(c);
			 * });
			 * todosClientes.forEach(System.out::println);
			 */
			System.out.println(clienteRepository.existsByNome("Pedro Atualizado"));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
