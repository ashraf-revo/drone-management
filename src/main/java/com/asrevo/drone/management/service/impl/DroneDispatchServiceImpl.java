package com.asrevo.drone.management.service.impl;

import com.asrevo.drone.management.api.exception.ApiException;
import com.asrevo.drone.management.api.exception.DroneNotLoadedException;
import com.asrevo.drone.management.api.exception.ErrorCodes;
import com.asrevo.drone.management.domain.DroneEntity;
import com.asrevo.drone.management.domain.DroneId;
import com.asrevo.drone.management.domain.PackageInfo;
import com.asrevo.drone.management.domain.State;
import com.asrevo.drone.management.dto.DroneDto;
import com.asrevo.drone.management.mappers.DroneMapper;
import com.asrevo.drone.management.repository.DroneRepository;
import com.asrevo.drone.management.service.DroneDispatchService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@AllArgsConstructor
@Slf4j
public class DroneDispatchServiceImpl implements DroneDispatchService {
    private final DroneRepository droneRepository;
    private final DroneMapper droneMapper;

    @Override
    public DroneEntity loadingDrone(DroneId droneId) {
        DroneEntity drone = getDrone(droneId);
        return droneRepository.save(drone.loadingDrone());
    }

    @Override
    public DroneEntity loadedPackage(DroneId droneId, PackageInfo packageInfo) {
        packageInfo.validate();
        DroneEntity drone = getDrone(droneId);
        return droneRepository.save(drone.loadedPackage(packageInfo));
    }

    @Override
    public DroneEntity startDeliveringPackage(DroneId droneId) {
        DroneEntity drone = getDrone(droneId);
        return droneRepository.save(drone.startDeliveringPackage());
    }

    @Override
    public DroneEntity markDeliveredPackage(DroneId droneId) {
        DroneEntity drone = getDrone(droneId);
        return droneRepository.save(drone.markDeliveredPackage());
    }

    @Override
    public DroneEntity startReturningDrone(DroneId droneId) {
        DroneEntity drone = getDrone(droneId);
        return droneRepository.save(drone.startReturningDrone());
    }

    @Override
    public DroneEntity markReturnedDrone(DroneId droneId) {
        DroneEntity drone = getDrone(droneId);
        return droneRepository.save(drone.markReturningDrone());
    }

    @Override
    public List<DroneDto> findAllForLoading() {
        return droneRepository.findAllByStateAndBatteryCapacityGreaterThanEqual(State.IDLE, 25f)
                .stream()
                .map(droneMapper::toDto)
                .toList();
    }

    @Override
    public PackageInfo loadedPackageInfo(DroneId droneId) {
        DroneEntity drone = getDrone(droneId);
        return drone.getLoadedPackage();
    }

    @Override
    public Map<String, String> batteryLevel(DroneId droneId) {
        DroneEntity drone = getDrone(droneId);
        return Map.of("battery-level", drone.getBatteryCapacity().toString());
    }

    @Override
    public Map<String, String> state(DroneId droneId) {
        DroneEntity drone = getDrone(droneId);
        return Map.of("state", drone.getState().toString());
    }

    private DroneEntity getDrone(DroneId droneId) {
        return droneRepository.findById(droneId).orElseThrow(() -> new ApiException(ErrorCodes.NO_DRONE_EXIST_WITH_THIS_ID));
    }
}
