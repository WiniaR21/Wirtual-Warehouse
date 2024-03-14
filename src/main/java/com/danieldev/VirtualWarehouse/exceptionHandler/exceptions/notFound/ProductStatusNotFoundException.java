package com.danieldev.VirtualWarehouse.exceptionHandler.exceptions.notFound;

public class ProductStatusNotFoundException extends RuntimeException{
    public ProductStatusNotFoundException(Long id){
        super("Product status with id: " + id + " not found");
    }
}
