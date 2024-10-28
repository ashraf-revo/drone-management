package com.asrevo.drone.management.event;

import com.asrevo.drone.management.commons.domain.EventId;
import com.asrevo.drone.management.domain.DroneEntity;
import com.asrevo.drone.management.domain.State;

import java.util.Map;

public class DroneEventBuilder {

    public static DroneEvent droneCreated(DroneEntity entity) {
        EventId id = EventId.newId();
        String eventType = "DRONE_CREATED";
        Map<String, String> attributes = Map.of("ref", entity.getId().toString(),"currentState",entity.getState().toString());
        return new DroneCreatedEvent(id, eventType, attributes);
    }

    public static DroneEvent droneStateChanged(DroneEntity entity, State oldState) {
        EventId id = EventId.newId();
        String eventType = "DRONE_STATE_CHANGED";
        Map<String, String> attributes = Map.of("ref", entity.getId().toString(), "oldState", oldState.toString(), "currentState", entity.getState().toString());
        return new DroneStateChangedEvent(id, eventType, attributes);
    }

}

