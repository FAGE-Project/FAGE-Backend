package com.example.fage.Exceptions;

public class InvalidCompanyNameException extends Exception{

    public InvalidCompanyNameException(String errorMessage){
        super(errorMessage);
    }

}
