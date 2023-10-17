package com.diegojacober.springsecurity.repository;

import com.diegojacober.springsecurity.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByLogin(String login);

}