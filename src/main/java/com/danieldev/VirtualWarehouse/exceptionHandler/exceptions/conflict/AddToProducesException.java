package com.danieldev.VirtualWarehouse.exceptionHandler.exceptions.conflict;

public class AddToProducesException extends RuntimeException{
    public AddToProducesException(Long departmentId, Long productNameId) {
        super("Cannot add to produces product name with id: " + productNameId + " because department with id: " + departmentId + " already contain this product name");
    }
}
