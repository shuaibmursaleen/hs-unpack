package com.shuaib.hscodes.taxbreakdown.exception;

import lombok.Getter;

@Getter
public class ErrorResponse {
    private String message;

    public ErrorResponse(String message) {
        this.message = message;
    }
}
