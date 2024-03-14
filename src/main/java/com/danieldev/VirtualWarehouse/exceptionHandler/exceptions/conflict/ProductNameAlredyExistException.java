package com.danieldev.VirtualWarehouse.exceptionHandler.exceptions.conflict;

public class ProductNameAlredyExistException extends RuntimeException{
    public ProductNameAlredyExistException() {
        super("This product name alredy exist");
    }
}
