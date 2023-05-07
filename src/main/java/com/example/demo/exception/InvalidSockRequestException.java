package com.example.demo.exception;

public class InvalidSockRequestException extends RuntimeException{

    public InvalidSockRequestException(String message) {
        super(message);
    }
}
