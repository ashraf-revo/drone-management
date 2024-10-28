package com.asrevo.drone.management.commons.domain;

import java.util.UUID;

public record EventId(String id) {
    public static EventId newId() {
        return new EventId(UUID.randomUUID().toString());
    }
}
