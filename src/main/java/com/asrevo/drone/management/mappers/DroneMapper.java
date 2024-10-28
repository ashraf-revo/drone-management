package com.asrevo.drone.management.mappers;

import com.asrevo.drone.management.api.exception.ErrorCodes;
import com.asrevo.drone.management.api.exception.ValidationException;
import com.asrevo.drone.management.domain.DroneEntity;
import com.asrevo.drone.management.domain.Model;
import com.asrevo.drone.management.domain.PackageInfo;
import com.asrevo.drone.management.domain.Serial;
import com.asrevo.drone.management.dto.DroneDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DroneMapper {
    default Serial toSerial(String serial) {
        try {
            return Serial.of(serial);
        } catch (Exception e) {
            throw new ValidationException(e.getMessage(), ErrorCodes.INVALID_SERIAL);
        }
    }

    default Float toBatteryCapacity(Float batteryCapacity) {
        if (batteryCapacity == null) {
            throw new ValidationException("battery capacity can't be null", ErrorCodes.INVALID_BATTERY_CAPACITY);
        }
        if (batteryCapacity > 100) {
            throw new ValidationException("battery capacity can't be greeter than 100", ErrorCodes.INVALID_BATTERY_CAPACITY);
        }
        if (batteryCapacity < 0) {
            throw new ValidationException("battery capacity can't be less than 0", ErrorCodes.INVALID_BATTERY_CAPACITY);
        }
        return batteryCapacity;
    }

    default Model toModel(Integer lightWeight, Integer middleWeight, Integer cruiserWeight, Integer heavyWeight) {
        return new Model(lightWeight, middleWeight, cruiserWeight, heavyWeight);
    }

    default Integer toWightLimit(Integer wightLimit) {
        if (wightLimit == null) {
            throw new ValidationException("wight Limit can't be null", ErrorCodes.INVALID_WIGHT_LIMIT);
        }
        return wightLimit;
    }

    default DroneDto toDto(DroneEntity entity) {
        PackageInfo packageInfo = null;
        if (entity.getPackageEntity() != null) {
            packageInfo = entity.getPackageEntity().getPackageInfo();
        }
        return new DroneDto(entity.getId(), entity.getSerial(), entity.getModel(), entity.getState(), entity.getBatteryCapacity(), entity.getWightLimit(), packageInfo);
    }
}
