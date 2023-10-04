package com.diegojacober.jpa.demo.domain.entity.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.diegojacober.jpa.demo.domain.entity.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class ClienteRepository {

    private static String INSERT = "insert into cliente (nome) values (?);";
    private static String SELECT_ALL = "select * from cliente;";
    private static String SELECT_POR_NOME = "select * from cliente where nome like ?";
    private static String UPDATE = "update cliente set nome = ? where id = ?;";
    private static String DELETE = "delete cliente where id = ?;";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Cliente salvar(Cliente cliente) {
        // jdbcTemplate.update(INSERT, new Object[] { cliente.getNome() });
        entityManager.persist(cliente);
        return cliente;
    }

    @Transactional
    public Cliente atualizar(Cliente cliente) {
        // jdbcTemplate.update(UPDATE, new Object[] { cliente.getNome(), cliente.getId()
        // });
        entityManager.merge(cliente);
        return cliente;
    }

    @Transactional
    public void deletar(Cliente cliente) {
        // deletar(cliente.getId());
        if (!entityManager.contains(cliente)) {
            cliente = entityManager.merge(cliente);
        }
        entityManager.remove(cliente);
    }

    @Transactional
    public void deletar(Integer id) {
        // jdbcTemplate.update(DELETE, id);
        Cliente cliente = entityManager.find(Cliente.class, id);
        deletar(cliente);
    }

    @Transactional(readOnly = true)
    public List<Cliente> buscarPorNome(String nome) {
        // return jdbcTemplate.query(SELECT_POR_NOME, new Object[]{"%" + nome + "%"},
        // obterClienteMapper());
        String jpql = " select c from Cliente c where c.nome like :nome ";
        TypedQuery<Cliente> query = entityManager.createQuery(jpql, Cliente.class);
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    public List<Cliente> obterTodos() {
        // return jdbcTemplate.query(SELECT_ALL, obterClienteMapper());
        return entityManager.createQuery("from Cliente", Cliente.class).getResultList();
    }

    // private RowMapper<Cliente> obterClienteMapper() {
    // return new RowMapper<Cliente>() {
    // @Override
    // public Cliente mapRow(ResultSet resultSet, int i) throws SQLException {
    // return new Cliente(resultSet.getInt("id"), resultSet.getString("nome"));
    // }
    // };
    // }
}
