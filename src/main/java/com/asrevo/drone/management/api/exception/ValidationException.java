package com.asrevo.drone.management.api.exception;

import lombok.Getter;

@Getter
public class ValidationException extends RuntimeException {
    private final ErrorCode errorCode;

    public ValidationException(String description, ErrorCode errorCode) {
        super(description);
        this.errorCode = errorCode;
    }
}


