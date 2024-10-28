package com.asrevo.drone.management.listener;

import com.asrevo.drone.management.event.DroneCreatedEvent;
import com.asrevo.drone.management.event.DroneStateChangedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@Slf4j
public class DroneEventListener {
    @TransactionalEventListener
    public void on(DroneCreatedEvent event) {
        log.info("DroneCreatedEvent: {}", event);
    }

    @TransactionalEventListener
    public void on(DroneStateChangedEvent event) {
        log.info("DroneStateChangedEvent: {}", event);
    }

}
