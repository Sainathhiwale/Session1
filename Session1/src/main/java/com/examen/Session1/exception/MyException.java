package com.examen.Session1.exception;

public class MyException extends RuntimeException{
    String message;

    public MyException(String message) {
        super(message);
    }

}
