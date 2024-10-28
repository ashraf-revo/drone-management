package com.asrevo.drone.management.event;

import com.asrevo.drone.management.commons.domain.EventId;

import java.util.Map;

public record DroneCreatedEvent(EventId id, String eventType, Map<String, String> attributes) implements DroneEvent {

}
