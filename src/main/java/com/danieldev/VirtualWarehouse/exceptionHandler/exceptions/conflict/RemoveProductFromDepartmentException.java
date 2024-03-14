package com.danieldev.VirtualWarehouse.exceptionHandler.exceptions.conflict;

public class RemoveProductFromDepartmentException extends RuntimeException{
    public RemoveProductFromDepartmentException(Long productId, Long departmentId) {
        super("Cannot remove product with id: " + productId + " because department with id: " + departmentId + " do not contain this product");
    }
}
