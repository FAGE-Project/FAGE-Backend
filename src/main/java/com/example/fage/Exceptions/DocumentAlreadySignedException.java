package com.example.fage.Exceptions;

public class DocumentAlreadySignedException extends Exception{

    public DocumentAlreadySignedException(String errorMessage){
        super(errorMessage);
    }
}
