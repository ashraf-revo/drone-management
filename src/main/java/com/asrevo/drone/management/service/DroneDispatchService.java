package com.asrevo.drone.management.service;

import com.asrevo.drone.management.domain.DroneEntity;
import com.asrevo.drone.management.domain.DroneId;
import com.asrevo.drone.management.domain.PackageInfo;
import com.asrevo.drone.management.dto.DroneDto;

import java.util.List;
import java.util.Map;

public interface DroneDispatchService {
    DroneEntity loadingDrone(DroneId droneId);

    DroneEntity loadedPackage(DroneId droneId,PackageInfo packageInfo);

    DroneEntity startDeliveringPackage(DroneId droneId);

    DroneEntity markDeliveredPackage(DroneId droneId);

    DroneEntity startReturningDrone(DroneId droneId);

    DroneEntity markReturnedDrone(DroneId droneId);

    List<DroneDto> findAllForLoading();

    PackageInfo loadedPackageInfo(DroneId droneId);

    Map<String, String> batteryLevel(DroneId droneId);

    Map<String, String> state(DroneId droneId);
}
