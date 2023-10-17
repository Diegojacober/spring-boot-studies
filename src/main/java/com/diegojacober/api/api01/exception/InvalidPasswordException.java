package com.diegojacober.api.api01.exception;

public class InvalidPasswordException extends RuntimeException{

    public InvalidPasswordException() {
        super("Incorrect credentials");
    }
}
