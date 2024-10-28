package com.asrevo.drone.management.event;

import com.asrevo.drone.management.commons.domain.Event;

public interface DroneEvent extends Event {
    @Override
    default String rootObject() {
        return "DRONE";
    }
}
