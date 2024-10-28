package com.asrevo.drone.management.jobs;

import com.asrevo.drone.management.domain.DroneHistoryEntity;
import com.asrevo.drone.management.dto.DroneDto;
import com.asrevo.drone.management.repository.DroneHistoryRepository;
import com.asrevo.drone.management.service.DroneService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class BatteryCapacityJob {

    private final DroneService droneService;
    private final DroneHistoryRepository historyRepository;

    @Scheduled(fixedRate = 5000)
    public void checkBatteryCapacity() {
        log.info("Checking battery capacity...");
        List<DroneDto> list = droneService.fetchDroneBatteryCapacity();
        log.info("Got {} battery capacity", list.size());
        list.forEach(it -> {
            DroneHistoryEntity h = DroneHistoryEntity.log(it.id(), it.batteryCapacity());
            DroneHistoryEntity saved = historyRepository.save(h);
            log.info("Got {} battery capacity for drone {} stored with log-id {}", it.batteryCapacity(), it.id(), saved.getId());
        });
    }
}
