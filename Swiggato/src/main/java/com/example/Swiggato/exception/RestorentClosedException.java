package com.example.Swiggato.exception;

public class RestorentClosedException extends RuntimeException{
    public RestorentClosedException(String message){
        super(message);
    }
}
