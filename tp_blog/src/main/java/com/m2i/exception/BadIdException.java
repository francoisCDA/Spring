package com.m2i.exception;

public class BadIdException extends RuntimeException {
    public BadIdException(){
        super("identifiants invalides");
    }
}
