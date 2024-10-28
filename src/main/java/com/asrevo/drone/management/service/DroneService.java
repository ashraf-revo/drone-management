package com.asrevo.drone.management.service;

import com.asrevo.drone.management.domain.DroneId;
import com.asrevo.drone.management.dto.DroneDto;
import com.asrevo.drone.management.dto.RegisterDroneRequest;

import java.util.List;
import java.util.Optional;

public interface DroneService {
    DroneDto registerNewDrone(RegisterDroneRequest request);

    Optional<DroneDto> findOne(DroneId id);

    List<DroneDto> findAll();

    List<DroneDto> fetchDroneBatteryCapacity();
}
