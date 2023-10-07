package com.diegojacober.api.api01.rest.controller;

import java.util.Optional;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
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
import org.springframework.web.bind.annotation.RestController;

import com.diegojacober.api.api01.domain.entity.Cliente;
import com.diegojacober.api.api01.domain.entity.repository.ClienteRepository;

@Controller // forma01
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @RequestMapping(value = { "/api/clientes/hello/{nome}", "/api/clientes/hello" }, method = RequestMethod.GET,
            // o que a requisição aceita
            consumes = { "application/json", "application/xml" },
            // o que a requisição pode retornar
            produces = { "application/json", "application/xml" })
    @ResponseBody
    public String helloCliente(@PathVariable("nome") String nomeCliente) {
        return String.format("Hello %s ", nomeCliente);
    }

    @GetMapping(value = "/api/clientes/{id}")
    @ResponseBody
    public ResponseEntity<Cliente> getClienteById(@PathVariable Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);

        if (cliente.isPresent()) {
            return ResponseEntity.ok().body(cliente.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/api/clientes")
    @ResponseBody
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
        Cliente clienteSalvo = clienteRepository.save(cliente);
        return ResponseEntity.ok(clienteSalvo);
    }

    @DeleteMapping("/api/clientes/{id}")
    @ResponseBody
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);

        if (cliente.isPresent()) {
            clienteRepository.delete(cliente.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/api/clientes/{id}")
    @ResponseBody
    public ResponseEntity<Cliente> update(@PathVariable Integer id, @RequestBody Cliente cliente) {
        Optional<Cliente> c = clienteRepository.findById(id);
 
        if(c.isPresent()){
            cliente.setId(c.get().getId());
            Cliente clienteAtualizado = clienteRepository.save(cliente);
            return ResponseEntity.ok(clienteAtualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/api/clientes")
    @ResponseBody
    public ResponseEntity<List<Cliente>> find(Cliente filtro) {
        ExampleMatcher matcher = ExampleMatcher.matching()
        .withIgnoreCase()
        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        
        Example example = Example.of(filtro, matcher);
        List<Cliente> clientes = clienteRepository.findAll(example);
        return ResponseEntity.ok(clientes);
    }
}
