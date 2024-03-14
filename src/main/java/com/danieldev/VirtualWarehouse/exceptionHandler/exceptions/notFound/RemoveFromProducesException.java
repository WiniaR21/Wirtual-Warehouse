package com.danieldev.VirtualWarehouse.exceptionHandler.exceptions.notFound;

public class RemoveFromProducesException extends RuntimeException {
    public RemoveFromProducesException(Long departmentId, Long productNameId) {
        super("Department with id: " + departmentId + " do not contain product name with id: " + productNameId);
    }
}
