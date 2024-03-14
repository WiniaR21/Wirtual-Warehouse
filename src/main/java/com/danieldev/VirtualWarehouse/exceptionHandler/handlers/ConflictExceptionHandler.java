package com.danieldev.VirtualWarehouse.exceptionHandler.handlers;

import com.danieldev.VirtualWarehouse.exceptionHandler.exceptions.conflict.*;
import com.danieldev.VirtualWarehouse.exceptionHandler.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ConflictExceptionHandler {

    @ExceptionHandler({
            PackagingAlredyExistException.class,
            ProductNameAlredyExistException.class,
            ProductStatusAlredyExistException.class,
            DepartmentAlredyExistException.class,
            TransportConflictException.class,
            AddToProducesException.class,
            RemoveProductFromDepartmentException.class,
            RemovePackagingConflictException.class,
            RemoveDepartmentException.class,
            RemoveProductStatusException.class,
            RemoveProductNameException.class,
            RegisterUserNameException.class
    })
    public ResponseEntity<ExceptionResponse> handle404Exceptions(RuntimeException e) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new ExceptionResponse(e.getMessage()));
    }
}