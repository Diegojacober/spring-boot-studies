package com.diegojacober.api.api01.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.diegojacober.api.api01.domain.entity.Cliente;
import com.diegojacober.api.api01.domain.entity.repository.ClienteRepository;

// @Controller // forma01
@RestController // forma02
@RequestMapping(value = "api/clientes") // forma02
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @RequestMapping(value = { "/hello/{nome}", "/hello" }, method = RequestMethod.GET,
            // o que a requisição aceita
            consumes = { "application/json", "application/xml" },
            // o que a requisição pode retornar
            produces = { "application/json", "application/xml" })
    // @ResponseBody
    public String helloCliente(@PathVariable("nome") String nomeCliente) {
        return String.format("Hello %s ", nomeCliente);
    }

    @GetMapping(value = "/{id}")
    // @ResponseBody //Não precisa com o restcontroller
    public Cliente getClienteById(@PathVariable Integer id) {
        // Optional<Cliente> cliente = clienteRepository.findById(id);

        // if (cliente.isPresent()) {
        // return cliente.get();
        // }
        // throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não
        // encontrado");
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @PostMapping
    // @ResponseBody
    @ResponseStatus(code = HttpStatus.CREATED)
    // public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
    // Cliente clienteSalvo = clienteRepository.save(cliente);
    // return ResponseEntity.ok(clienteSalvo);
    // }
    public Cliente save(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @DeleteMapping("/{id}")
    // @ResponseBody
    // public ResponseEntity<Void> delete(@PathVariable Integer id) {
    // Optional<Cliente> cliente = clienteRepository.findById(id);

    // if (cliente.isPresent()) {
    // clienteRepository.delete(cliente.get());
    // return ResponseEntity.noContent().build();
    // }
    // return ResponseEntity.notFound().build();
    // }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public Void delete(@PathVariable Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);

        if (cliente.isPresent()) {
            clienteRepository.delete(cliente.get());
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
    }

    @PutMapping("/{id}")
    // @ResponseBody
    // public ResponseEntity<Cliente> update(@PathVariable Integer id, @RequestBody
    // Cliente cliente) {
    // Optional<Cliente> c = clienteRepository.findById(id);

    // if (c.isPresent()) {
    // cliente.setId(c.get().getId());
    // Cliente clienteAtualizado = clienteRepository.save(cliente);
    // return ResponseEntity.ok(clienteAtualizado);
    // }
    // return ResponseEntity.notFound().build();
    // }
    @ResponseStatus(code = HttpStatus.OK)
    public Cliente update(@PathVariable Integer id, @RequestBody Cliente cliente) {
        Optional<Cliente> c = clienteRepository.findById(id);

        if (c.isPresent()) {
            cliente.setId(c.get().getId());
            Cliente clienteAtualizado = clienteRepository.save(cliente);
            return clienteAtualizado;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
    }

    @GetMapping
    // @ResponseBody
    // public ResponseEntity<List<Cliente>> find(Cliente filtro) {
    //     ExampleMatcher matcher = ExampleMatcher.matching()
    //             .withIgnoreCase()
    //             .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

    //     Example<Cliente> example = Example.of(filtro, matcher);
    //     List<Cliente> clientes = clienteRepository.findAll(example);
    //     return ResponseEntity.ok(clientes);
    // }
    @ResponseStatus(code = HttpStatus.OK)
    public List<Cliente> find(Cliente filtro) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Cliente> example = Example.of(filtro, matcher);
        return clienteRepository.findAll(example);
    }
}
