package com.danieldev.VirtualWarehouse.exceptionHandler.exceptions.notFound;

public class PackagingNotFoundException extends RuntimeException{
    public PackagingNotFoundException(Long id){
        super("Packaging with id: " + id + " not found");
    }
}
