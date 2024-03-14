package com.danieldev.VirtualWarehouse.exceptionHandler.exceptions.conflict;

public class TransportConflictException extends RuntimeException{
    public TransportConflictException(Long productId, Long departmentId) {
        super("Cannot transport because product with id: " + productId + " already is in department with id: " + departmentId);
    }
}
