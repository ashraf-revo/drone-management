package com.asrevo.drone.management.dto;

import com.asrevo.drone.management.domain.*;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public record DroneDto(DroneId id, Serial serial, Model model, State state, Float batteryCapacity, Integer wightLimit,
                       PackageInfo packageInfo) {
}
