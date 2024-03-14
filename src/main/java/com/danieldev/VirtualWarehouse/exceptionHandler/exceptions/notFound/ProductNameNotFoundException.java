package com.danieldev.VirtualWarehouse.exceptionHandler.exceptions.notFound;

public class ProductNameNotFoundException extends RuntimeException{
    public ProductNameNotFoundException(Long id){
        super("Product name with id: " + id + " not found");
    }
}
