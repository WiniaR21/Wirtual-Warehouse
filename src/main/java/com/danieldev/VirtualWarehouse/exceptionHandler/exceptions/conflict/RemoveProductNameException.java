package com.danieldev.VirtualWarehouse.exceptionHandler.exceptions.conflict;

public class RemoveProductNameException extends RuntimeException{
    public RemoveProductNameException(Long id) {
        super("Cannot remove product name with id: " + id + " because some products using it");
    }
}
