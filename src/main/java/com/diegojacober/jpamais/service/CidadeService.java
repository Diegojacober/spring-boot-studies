package com.diegojacober.jpamais.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.diegojacober.jpamais.domain.entity.Cidade;
import com.diegojacober.jpamais.domain.repository.CidadeRepository;
import com.diegojacober.jpamais.domain.repository.specs.CidadeSpecs;

@Service
public class CidadeService {

    @Autowired
    public CidadeRepository repository;

    public void listarCidades() {
        repository.findAll().forEach(System.out::println);
    }

    public void listarCidadesPorHabitantes() {
        repository.findByHabitantesGreaterThanEqual(999L, PageRequest.of(0, 3, Sort.by("nome")))
                .forEach(System.out::println);
    }

    public void listarCidadesPorNome() {
        repository.findByNomeContaining("C", Sort.by("habitantes")).forEach(System.out::println);
        ;
    }

    public List<Cidade> filtroDinamico(Cidade cidade) {
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase();
        Example<Cidade> example = Example.of(cidade, matcher);
        return repository.findAll(example);
    }

    public void listarCidadesByNomeSpecs() {
        repository.findAll(CidadeSpecs.nomeEqual("campinas").and(CidadeSpecs.habitantesGreaterThan(1000L)))
                .forEach(System.out::println);
    }

    public void listarCidadeSpecsFiltroDinamico(Cidade filtro) {
        Specification<Cidade> specs = Specification.where((root, query, cb) -> cb.conjunction());

        if (filtro.getId() != null) {
            specs = specs.and(CidadeSpecs.idEqual((filtro.getId())));
        }

        if (StringUtils.hasText(filtro.getNome())) {
            specs = specs.and(CidadeSpecs.nomeEqual((filtro.getNome())));
        }

        if(filtro.getHabitantes() != null) {
            specs = specs.and(CidadeSpecs.habitantesGreaterThan(filtro.getHabitantes()));
        }

        repository.findAll(specs).forEach(System.out::println);
    }
}
