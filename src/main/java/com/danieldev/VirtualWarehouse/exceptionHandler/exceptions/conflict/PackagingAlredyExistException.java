package com.danieldev.VirtualWarehouse.exceptionHandler.exceptions.conflict;

public class PackagingAlredyExistException extends RuntimeException{
    public PackagingAlredyExistException() {
        super("This packaging alredy exist");
    }
}
