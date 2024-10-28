package com.asrevo.drone.management.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table(name = "drone_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DroneHistoryEntity extends AbstractAggregateRoot<DroneHistoryEntity> implements Persistable<DroneHistoryId> {
    @Id
    private DroneHistoryId id;
    @Version
    private Integer version;
//    @Embedded(onEmpty = Embedded.OnEmpty.USE_NULL)
    private String droneId;
    private Float batteryCapacity;

    public static DroneHistoryEntity log(DroneId droneId, Float batteryCapacity) {
        DroneHistoryEntity entity = new DroneHistoryEntity();
        entity.setId(new DroneHistoryId(UUID.randomUUID().toString()));
        entity.setDroneId(droneId.id());
        entity.setBatteryCapacity(batteryCapacity);
        return entity;
    }

    @Override
    public boolean isNew() {
        return version == null;
    }

}

