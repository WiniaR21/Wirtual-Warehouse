package com.danieldev.VirtualWarehouse.exceptionHandler.exceptions.conflict;

public class ProductStatusAlredyExistException extends RuntimeException{
    public ProductStatusAlredyExistException() {
        super("This product status alredy exist");
    }
}
