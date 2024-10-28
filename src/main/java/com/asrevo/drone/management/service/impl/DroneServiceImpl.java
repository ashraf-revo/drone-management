package com.asrevo.drone.management.service.impl;

import com.asrevo.drone.management.api.exception.ErrorCode;
import com.asrevo.drone.management.api.exception.ErrorCodes;
import com.asrevo.drone.management.api.exception.ValidationException;
import com.asrevo.drone.management.domain.DroneEntity;
import com.asrevo.drone.management.domain.DroneId;
import com.asrevo.drone.management.domain.Model;
import com.asrevo.drone.management.domain.Serial;
import com.asrevo.drone.management.dto.DroneDto;
import com.asrevo.drone.management.dto.RegisterDroneRequest;
import com.asrevo.drone.management.mappers.DroneMapper;
import com.asrevo.drone.management.repository.DroneRepository;
import com.asrevo.drone.management.service.DroneService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class DroneServiceImpl implements DroneService {
    private final DroneRepository droneRepository;
    private final DroneMapper droneMapper;

    @Override
    public DroneDto registerNewDrone(RegisterDroneRequest request) {
        Serial serial = droneMapper.toSerial(request.serial());
        Float batteryCapacity = droneMapper.toBatteryCapacity(request.batteryCapacity());
        Model model = droneMapper.toModel(request.lightWeight(), request.middleWeight(), request.cruiserWeight(), request.heavyWeight());
        Integer wightLimit = droneMapper.toWightLimit(request.wightLimit());
        validateSerialExist(serial);
        DroneEntity saved = droneRepository.save(DroneEntity.newDrone(serial, model, batteryCapacity, wightLimit));
        return droneMapper.toDto(saved);
    }

    @Override
    public Optional<DroneDto> findOne(DroneId id) {
        return droneRepository.findById(id)
                .map(droneMapper::toDto);
    }

    @Override
    public List<DroneDto> findAll() {
        return droneRepository.findAllByQuery()
                .stream()
                .map(droneMapper::toDto)
                .toList();
    }

    @Override
    public List<DroneDto> fetchDroneBatteryCapacity() {
        return droneRepository.fetchDroneBatteryCapacity()
                .stream()
                .map(droneMapper::toDto)
                .toList();

    }

    private void validateSerialExist(Serial serial) {
        droneRepository.findBySerial(serial).ifPresent((x) -> {
            ErrorCode errorCode = ErrorCodes.DRONE_SERIAL_EXIST;
            throw new ValidationException(errorCode.description(), errorCode);
        });
    }
}
