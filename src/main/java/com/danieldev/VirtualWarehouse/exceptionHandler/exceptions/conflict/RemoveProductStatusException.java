package com.danieldev.VirtualWarehouse.exceptionHandler.exceptions.conflict;

public class RemoveProductStatusException extends RuntimeException{
    public RemoveProductStatusException(Long id) {
        super("Cannot remove product status with id: " + id + " because some products using it");
    }
}
