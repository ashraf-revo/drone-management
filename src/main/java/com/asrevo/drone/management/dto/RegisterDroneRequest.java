package com.asrevo.drone.management.dto;


public record RegisterDroneRequest(String serial, Integer lightWeight, Integer middleWeight, Integer cruiserWeight, Integer heavyWeight, Float batteryCapacity, Integer wightLimit) {
}
