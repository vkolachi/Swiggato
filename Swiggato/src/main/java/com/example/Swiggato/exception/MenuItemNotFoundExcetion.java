package com.example.Swiggato.exception;

public class MenuItemNotFoundExcetion extends RuntimeException{
    public MenuItemNotFoundExcetion(String message){
        super(message);
    }
}
