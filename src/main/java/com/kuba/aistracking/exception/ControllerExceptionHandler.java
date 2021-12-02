package com.kuba.aistracking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ControllerException.class)
    public ResponseEntity<ErrorInfo> handleException(ControllerException e) {
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        if (ControllerError.ROCKET_NOT_FOUND.equals(e.getControllerError())
                || ControllerError.BASE_NOT_FOUND.equals(e.getControllerError())) {
            httpStatus = HttpStatus.NOT_FOUND;
        }
        return ResponseEntity.status(httpStatus).body(new ErrorInfo(e.getControllerError().getMessage()));
    }

}
