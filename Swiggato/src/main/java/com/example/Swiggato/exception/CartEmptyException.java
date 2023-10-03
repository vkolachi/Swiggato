package com.example.Swiggato.exception;

public class CartEmptyException extends RuntimeException{
    public  CartEmptyException(String message){
        super(message);
    }
}
