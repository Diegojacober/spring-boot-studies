package com.secao01.secao01.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secao01.secao01.Repositories.ClienteRepository;
import com.secao01.secao01.model.Cliente;

@Service
public class ClienteService {

    //@Autowired
    //Se não pretende fazer testes pode colocar em cima da propriedade. Caso precise fazer mocks das dependências será necessário injetar via construtor.
    private ClienteRepository clienteRepository;
    
     
    // Quando tiver assim, não é necessário o Autowired em lugar nenhum
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void salvarCliente(Cliente cliente) {
        validarCliente(cliente);
        //Forma errada
        //ClienteRepository clienteRepository = new ClienteRepository();
        clienteRepository.persistir(cliente);
    }

    public void validarCliente(Cliente cliente) {
        //validações
    }
}
