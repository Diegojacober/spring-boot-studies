package com.diegojacober.jpamais.domain.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.diegojacober.jpamais.domain.entity.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>, JpaSpecificationExecutor<Cidade>{
    //Buscar pelo nome correto
    List<Cidade> findByNome(String nome, Sort sort);

    List<Cidade> findByHabitantes(Long habitantes);
    
    // Começar com 
    List<Cidade> findByNomeStartsWith(String nome);

    // Terminando com
    List<Cidade> findByNomeEndingWith(String nome);

    // Contendo 
    List<Cidade> findByNomeContaining(String nome, Sort sort);

    // Busca pelo like 
    // tem que passar as % de como quer igual no sql
    @Query("select c from Cidade c where lower( c.nome) like lower(:l)") // para poder trabalhar com case
    List<Cidade> findByNomeLike(@Param("l") String l);

    // Menor que
    List<Cidade> findByHabitantesLessThan(Long habitantes);

    // Mais que
    List<Cidade> findByHabitantesGreaterThan(Long habitantes);

     // Menor ou igual a
    List<Cidade> findByHabitantesLessThanEqual(Long habitantes);

    // Maior ou igual a
    Page<Cidade> findByHabitantesGreaterThanEqual(Long habitantes, Pageable sort);


    // Maior ou igual a e contem no nome
    List<Cidade> findByHabitantesGreaterThanEqualAndNomeContaining(Long habitantes, String nome);
    
    
}
