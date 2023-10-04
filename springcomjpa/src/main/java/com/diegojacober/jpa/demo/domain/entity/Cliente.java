package com.diegojacober.jpa.demo.domain.entity;

public class Cliente {
    private Integer id;
    private String nome;

    public Cliente() {
    }

    public Cliente(Integer id, String name) {
        this.id = id;
        this.nome = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String name) {
        this.nome = name;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nome=" + nome + "]";
    }
}
