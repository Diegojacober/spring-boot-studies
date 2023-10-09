package com.diegojacober.api.api01.rest.controller;

import static org.springframework.http.HttpStatus.*;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.diegojacober.api.api01.exception.PedidoNaoEncontradoException;
import com.diegojacober.api.api01.exception.RegraNegocioException;
import com.diegojacober.api.api01.rest.ApiErrors;

@RestControllerAdvice
public class ApplicationControllerAdivce {
    
    @ExceptionHandler(RegraNegocioException.class)
    @ResponseStatus(BAD_REQUEST)
    public ApiErrors handleRegraNegocioException(RegraNegocioException ext) {
        String msgErro = ext.getMessage();
        return new ApiErrors(msgErro);
    }

    @ExceptionHandler(PedidoNaoEncontradoException.class)
    @ResponseStatus(NOT_FOUND)
    public ApiErrors handlePedidoNotFoundException(PedidoNaoEncontradoException ext) {
        return new ApiErrors(ext.getMessage());
    }
}
