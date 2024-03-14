package com.danieldev.VirtualWarehouse.exceptionHandler.handlers;

import com.danieldev.VirtualWarehouse.exceptionHandler.exceptions.conflict.DepartmentAlreadyContainProductException;
import com.danieldev.VirtualWarehouse.exceptionHandler.exceptions.notFound.*;
import com.danieldev.VirtualWarehouse.exceptionHandler.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NotFoundExceptionHandler {

    @ExceptionHandler({
            PackagingNotFoundException.class,
            ProductNameNotFoundException.class,
            ProductStatusNotFoundException.class,
            DepartmentNotFoundException.class,
            RemoveFromProducesException.class,
            ProductNotFoundException.class,
            DepartmentAlreadyContainProductException.class
    })
    public ResponseEntity<ExceptionResponse> handle404Exceptions(RuntimeException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ExceptionResponse(e.getMessage()));
    }
}
