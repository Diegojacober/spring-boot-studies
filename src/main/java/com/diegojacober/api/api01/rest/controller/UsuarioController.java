package com.diegojacober.api.api01.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.diegojacober.api.api01.domain.entity.Usuario;
import com.diegojacober.api.api01.exception.InvalidPasswordException;
import com.diegojacober.api.api01.rest.controller.dto.CredenciaisDTO;
import com.diegojacober.api.api01.rest.controller.dto.TokenDTO;
import com.diegojacober.api.api01.security.jwt.JwtService;
import com.diegojacober.api.api01.service.impl.UserServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UserServiceImpl usuarioService;

    @Autowired
    private JwtService jwtService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Usuario salvar(@RequestBody @Valid Usuario usuario) {
        Usuario user = usuarioService.salvar(usuario);
        return user;
    }

    @PostMapping("/auth")
    public TokenDTO autenticar(@RequestBody CredenciaisDTO credenciais) {
        try {
            Usuario user = Usuario.builder()
                    .login(credenciais.getLogin())
                    .senha(credenciais.getSenha()).build();

                UserDetails authenticatedUser = usuarioService.autenticar(user);
            
            String token = jwtService.gerarToken(user);
            return new TokenDTO(user.getLogin(), token);
        } catch (UsernameNotFoundException | InvalidPasswordException  e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }
}
