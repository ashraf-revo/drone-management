package com.asrevo.drone.management.repository;

import com.asrevo.drone.management.domain.DroneEntity;
import com.asrevo.drone.management.domain.DroneId;
import com.asrevo.drone.management.domain.Serial;
import com.asrevo.drone.management.domain.State;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DroneRepository extends CrudRepository<DroneEntity, DroneId> {
    Optional<DroneEntity> findBySerial(Serial serial);

    @Query("select d.id,d.serial,d.state from drone.drone d")
    List<DroneEntity> findAllByQuery();

    @Query("select d.id,d.serial from drone.drone d where d.state=:state and d.battery_capacity>=:batteryCapacity")
    List<DroneEntity> findAllByStateAndBatteryCapacityGreaterThanEqual(@Param("state") State state, @Param("batteryCapacity") Float batteryCapacity);

    @Query("select d.id,d.battery_capacity from drone.drone d")
    List<DroneEntity> fetchDroneBatteryCapacity();
}
