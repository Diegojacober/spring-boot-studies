package com.diegojacober.api.api01.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller // forma01
@RequestMapping("/api/clientes") //forma01
public class ClienteController {

    @RequestMapping(
     value = {"/hello/{nome}", "api/hello"},
     method = RequestMethod.GET,
     // o que a requisição aceita
     consumes = { "application/json", "application/xml" },
     // o que a requisição pode retornar
     produces = { "application/json", "application/xml" }
     )
    @ResponseBody
    public String helloCliente(@PathVariable("nome") String nomeCliente) {
        return String.format("Hello %s ", nomeCliente);
    }
}
