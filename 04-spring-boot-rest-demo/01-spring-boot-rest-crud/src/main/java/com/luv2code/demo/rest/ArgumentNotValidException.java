package com.luv2code.demo.rest;

public class ArgumentNotValidException extends RuntimeException{

    public ArgumentNotValidException(String message) {
        super(message);
    }

    public ArgumentNotValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArgumentNotValidException(Throwable cause) {
        super(cause);
    }
}
