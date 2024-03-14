package com.danieldev.VirtualWarehouse.exceptionHandler.exceptions.notFound;

public class DepartmentNotFoundException extends RuntimeException{
    public DepartmentNotFoundException(Long id) {
        super("Department with id: " + id + " not found");
    }
}
