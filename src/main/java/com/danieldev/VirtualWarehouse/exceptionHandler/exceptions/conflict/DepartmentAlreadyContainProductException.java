package com.danieldev.VirtualWarehouse.exceptionHandler.exceptions.conflict;

public class DepartmentAlreadyContainProductException extends RuntimeException{
    public DepartmentAlreadyContainProductException(Long productId, Long departmentId) {
        super("Cannot add product with id: " + productId + " because department with id: " + departmentId + " already contains it");
    }
}
