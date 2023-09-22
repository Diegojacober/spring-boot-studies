package com.secao01.secao01.Configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {
    
    @Bean(name = "applicationName") //Cria no contexto da aplicação
    public String applicationName() {
        return "Sistema de vendas";
    }

}
