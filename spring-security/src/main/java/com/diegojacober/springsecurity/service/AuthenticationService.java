package com.diegojacober.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.diegojacober.springsecurity.repository.UserRepository;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UserRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        return usuarioRepository.findByLogin(username);
    }
    
}
