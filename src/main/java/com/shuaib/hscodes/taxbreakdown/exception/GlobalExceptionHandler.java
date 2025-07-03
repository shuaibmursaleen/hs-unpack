package com.shuaib.hscodes.taxbreakdown.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(TaxBreakdownNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleTaxBreakdownNotFoundException(TaxBreakdownNotFoundException exception) {
        return new ErrorResponse(exception.getMessage());
    }
}
