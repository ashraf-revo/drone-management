package com.asrevo.drone.management.api.exception;

import lombok.Getter;

@Getter
public class DroneNotLoadedException extends RuntimeException {
    private final ErrorCode errorCode;

    public DroneNotLoadedException(ErrorCode errorCode) {
        super(errorCode.description());
        this.errorCode = errorCode;
    }
}


