package com.diegojacober.jpamais.domain.repository.specs;

import org.springframework.data.jpa.domain.Specification;

import com.diegojacober.jpamais.domain.entity.Cidade;

public abstract class CidadeSpecs {
    // https://maykonoliveira850.medium.com/listagem-com-filtragem-din%C3%A2mica-e-pagina%C3%A7%C3%A3o-usando-o-spring-boot-2b99dd1d7050
    public static Specification<Cidade> idEqual(Long id) {
        return (root, query, cb) -> cb.equal(root.get("id"), id); 
    }
    
    public static Specification<Cidade> nomeEqual(String nome) {
        return (root, query, cb) -> cb.equal(root.get("nome"), nome); 
    }

    public static Specification<Cidade> habitantesGreaterThan(Long value) {
        return (root, query, cb) -> cb.greaterThan(root.get("habitantes"), value);
    }

    public static Specification<Cidade> habitantesBetween(Long min, Long max) {
        return (root, query, cb) -> cb.between(root.get("habitantes"), min, max);
    }

    public static Specification<Cidade> nomeLike(String nome) {
        return (root, query, cb) -> cb.like(cb.upper(root.get("nome")), "%" + nome + "%".toUpperCase());
    }
}
