package com.cuemby.demo.main.exceptions.custom;

public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException(String message) {
        super(message);
    }

}
