package com.asrevo.drone.management.domain;

import com.asrevo.drone.management.api.exception.ErrorCodes;
import com.asrevo.drone.management.api.exception.ValidationException;
import org.springframework.data.relational.core.mapping.Embedded;

public record PackageInfo(@Embedded(onEmpty = Embedded.OnEmpty.USE_NULL) PackageName packageName,
                          Integer weight,
                          @Embedded(onEmpty = Embedded.OnEmpty.USE_NULL) PackageCode code,
                          @Embedded(onEmpty = Embedded.OnEmpty.USE_NULL) PackageImage image) {
    public void validate() {
        if (packageName == null) {
            throw new ValidationException("Invalid package name", ErrorCodes.INVALID_PACKAGE_NAME);
        }
        packageName.validate();
        if (code == null) {
            throw new ValidationException("Invalid package code", ErrorCodes.INVALID_PACKAGE_CODE);
        }
        code.validate();
    }
}
