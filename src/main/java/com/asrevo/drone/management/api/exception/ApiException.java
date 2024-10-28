package com.asrevo.drone.management.api.exception;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {
    private final ErrorCode errorCode;

    public ApiException(ErrorCode errorCode) {
        super(errorCode.description());
        this.errorCode = errorCode;
    }
}


