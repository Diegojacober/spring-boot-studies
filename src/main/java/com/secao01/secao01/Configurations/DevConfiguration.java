package com.secao01.secao01.Configurations;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.secao01.secao01.Development;

@Development
public class DevConfiguration {
    
    @Bean
    public CommandLineRunner executar() {
        return args -> {
            System.out.println("RODANDO CONFIGURAÇÃO DE DESENVOLVIMENTO");
        };
    }
}
