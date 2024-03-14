package com.danieldev.VirtualWarehouse.exceptionHandler.response;

import lombok.Data;

@Data
public class ExceptionResponse {
    private final boolean success = false;
    private String cause;

    public ExceptionResponse(String cause) {
        this.cause = cause;
    }
}
