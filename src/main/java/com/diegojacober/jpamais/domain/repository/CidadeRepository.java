package com.diegojacober.jpamais.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.diegojacober.jpamais.domain.entity.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{
    //Buscar pelo nome correto
    List<Cidade> findByNome(String nome);

    List<Cidade> findByHabitantes(Long habitantes);
    
    // Começar com 
    List<Cidade> findByNomeStartsWith(String nome);

    // Terminando com
    List<Cidade> findByNomeEndingWith(String nome);

    // Contendo 
    List<Cidade> findByNomeContaining(String nome);

    // Busca pelo like 
    // tem que passar as % de como quer igual no sql
    @Query("select c from Cidade c where lower(c.nome) like lower(?l)") // para poder trabalhar com case
    List<Cidade> findByNomeLike(String l);
}
