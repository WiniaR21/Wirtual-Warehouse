package com.danieldev.VirtualWarehouse.exceptionHandler.exceptions.conflict;

public class RegisterUserNameException extends RuntimeException{
    public RegisterUserNameException(String username) {
        super("Cannot register '" + username + "' because already exist" );
    }
}
