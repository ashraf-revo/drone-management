package com.asrevo.drone.management.domain;

import com.asrevo.drone.management.api.exception.ErrorCode;
import com.asrevo.drone.management.api.exception.ErrorCodes;
import lombok.Getter;

@Getter
public class DroneStateException extends IllegalStateException {
    private final ErrorCode errorCode = ErrorCodes.INVALID_DRONE_STATE;

    public DroneStateException(String s) {
        super(s);
    }
}
