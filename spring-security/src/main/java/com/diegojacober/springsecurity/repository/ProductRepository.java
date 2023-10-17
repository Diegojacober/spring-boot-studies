package com.diegojacober.springsecurity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.diegojacober.springsecurity.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query(value = "select * from product where user_id = :id", nativeQuery = true)
    List<Product> findyByUserId(Long id);
}
