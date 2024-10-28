package com.asrevo.drone.management.domain;

import com.asrevo.drone.management.api.exception.ErrorCodes;
import com.asrevo.drone.management.api.exception.ValidationException;

import java.util.Objects;

public record PackageCode(String code) {
    private final static PackageCodeValidator VALIDATOR = new PackageCodeValidator();

    public void validate() {
        if (Objects.isNull(code) || code.isEmpty()) {
            throw new ValidationException("Invalid package code: " + code, ErrorCodes.INVALID_PACKAGE_CODE);
        }
        if (!VALIDATOR.validate(code)) {
            throw new ValidationException("Invalid package code: " + code, ErrorCodes.INVALID_PACKAGE_CODE);
        }

    }
}
