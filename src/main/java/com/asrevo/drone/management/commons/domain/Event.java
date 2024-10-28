package com.asrevo.drone.management.commons.domain;

import java.util.Map;

public interface Event {
    EventId id();

    String eventType();

    String rootObject();

    Map<String, String> attributes();
}
