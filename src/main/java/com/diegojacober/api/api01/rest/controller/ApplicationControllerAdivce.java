package com.diegojacober.api.api01.rest.controller;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
}
