package com.danieldev.VirtualWarehouse.exceptionHandler.exceptions.notFound;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(Long id) {
        super("Product with id: " + id + " not found");
    }
}
