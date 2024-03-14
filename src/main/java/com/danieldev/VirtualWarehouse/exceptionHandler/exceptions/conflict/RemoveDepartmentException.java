package com.danieldev.VirtualWarehouse.exceptionHandler.exceptions.conflict;

public class RemoveDepartmentException extends RuntimeException{
    public RemoveDepartmentException(Long id) {
        super("Cannot remove department with id: " + id + " because there are products");
    }
}
