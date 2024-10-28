package com.asrevo.drone.management.repository;

import com.asrevo.drone.management.domain.DroneHistoryEntity;
import com.asrevo.drone.management.domain.DroneHistoryId;
import org.springframework.data.repository.CrudRepository;

public interface DroneHistoryRepository extends CrudRepository<DroneHistoryEntity, DroneHistoryId> {

}
