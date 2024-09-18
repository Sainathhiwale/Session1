package com.examen.Session1.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomAuthenticationException extends RuntimeException {
    private int code;
    private String details;

    public CustomAuthenticationException(String message, int code, String details) {
        super(message);
        this.code = code;
        this.details = details;
    }

}