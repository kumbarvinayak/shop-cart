package com.example.demo.Exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message, String id, Long aLong) {
        super(message);
    }
}
