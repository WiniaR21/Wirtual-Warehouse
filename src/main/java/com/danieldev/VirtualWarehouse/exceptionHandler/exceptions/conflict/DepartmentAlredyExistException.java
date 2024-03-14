package com.danieldev.VirtualWarehouse.exceptionHandler.exceptions.conflict;

public class DepartmentAlredyExistException extends RuntimeException {
    public DepartmentAlredyExistException() {
        super("This department alredy exist");
    }
}
