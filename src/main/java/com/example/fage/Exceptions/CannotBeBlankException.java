package com.example.fage.Exceptions;

public class CannotBeBlankException extends Exception{

    public CannotBeBlankException(String errorMessage){
        super(errorMessage);
    }
}
