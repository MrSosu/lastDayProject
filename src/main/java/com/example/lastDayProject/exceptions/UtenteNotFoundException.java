package com.example.lastDayProject.exceptions;

public class UtenteNotFoundException extends Exception {

    String message;

    public UtenteNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
