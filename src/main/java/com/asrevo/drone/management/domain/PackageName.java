package com.asrevo.drone.management.domain;

import com.asrevo.drone.management.api.exception.ErrorCodes;
import com.asrevo.drone.management.api.exception.ValidationException;

import java.util.Objects;

public record PackageName(String packageName) {
    private final static PackageNameValidator VALIDATOR = new PackageNameValidator();

    public void validate() {
        if (Objects.isNull(packageName) || packageName.isEmpty()) {
            throw new ValidationException("Invalid package name: " + packageName, ErrorCodes.INVALID_PACKAGE_CODE);
        }
        if (!VALIDATOR.validate(packageName)) {
            throw new ValidationException("Invalid package name: " + packageName, ErrorCodes.INVALID_PACKAGE_CODE);
        }

    }
}
