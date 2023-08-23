package com.example.fage.Exceptions;

public class EmailAlreadySignedException extends Exception{

    public EmailAlreadySignedException(String errorMessage) {
        super(errorMessage);
    }
}
