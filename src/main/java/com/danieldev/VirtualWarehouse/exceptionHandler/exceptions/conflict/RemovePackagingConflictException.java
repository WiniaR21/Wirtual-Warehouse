package com.danieldev.VirtualWarehouse.exceptionHandler.exceptions.conflict;

public class RemovePackagingConflictException extends RuntimeException{
    public RemovePackagingConflictException(Long id) {
        super("Cannot delete packaging with id: " + id + " because some product already using it");
    }
}
