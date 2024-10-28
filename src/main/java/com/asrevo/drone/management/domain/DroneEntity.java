package com.asrevo.drone.management.domain;

import com.asrevo.drone.management.api.exception.DroneNotLoadedException;
import com.asrevo.drone.management.api.exception.ErrorCodes;
import com.asrevo.drone.management.event.DroneEventBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;
import java.util.UUID;

@Table(name = "drone")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DroneEntity extends AbstractAggregateRoot<DroneEntity> implements Persistable<DroneId> {
    @Id
    private DroneId id;
    @Version
    private Integer version;
    @Embedded(onEmpty = Embedded.OnEmpty.USE_NULL)
    private Serial serial;
    @Embedded(onEmpty = Embedded.OnEmpty.USE_NULL)
    private Model model;
    private State state;
    private Float batteryCapacity;
    private Integer wightLimit;

    @MappedCollection(idColumn = "id")
    private DronePackageEntity packageEntity;

    public static DroneEntity newDrone(Serial serial, Model model, Float batteryCapacity, Integer wightLimit) {
        DroneEntity entity = new DroneEntity();
        entity.setId(new DroneId(UUID.randomUUID().toString()));
        entity.setSerial(serial);
        entity.setModel(model);
        entity.setBatteryCapacity(batteryCapacity);
        entity.setWightLimit(wightLimit);
        entity.setState(State.IDLE);
        entity.setPackageEntity(DronePackageEntity.createEmptyPackage(entity.getId()));
        entity.andEvent(DroneEventBuilder.droneCreated(entity));
        return entity;
    }

    @Override
    public boolean isNew() {
        return version == null;
    }

    public DroneEntity loadingDrone() {
        if (!State.IDLE.equals(state)) {
            throw new DroneStateException("Not in IDLE state");
        }
        if (this.batteryCapacity < 25) {
            throw new DroneStateException("Battery Capacity less than 25%");
        }
        State oldState = this.state;
        this.state = State.LOADING;
        this.andEvent(DroneEventBuilder.droneStateChanged(this, oldState));
        return this;
    }

    public DroneEntity loadedPackage(PackageInfo packageInfo) {
        if (!State.LOADING.equals(state)) {
            throw new DroneStateException("Not in LOADING state");
        }
        if (this.wightLimit < packageInfo.weight()) {
            throw new DroneStateException("Drone can't be loaded with wight more than its limit");
        }
        State oldState = this.state;
        this.state = State.LOADED;
        this.packageEntity.setPackageInfo(packageInfo);
        this.andEvent(DroneEventBuilder.droneStateChanged(this, oldState));
        return this;
    }

    public DroneEntity startDeliveringPackage() {
        if (!State.LOADED.equals(state)) {
            throw new DroneStateException("Not in LOADED state");
        }
        State oldState = this.state;
        this.state = State.DELIVERING;
        this.andEvent(DroneEventBuilder.droneStateChanged(this, oldState));
        return this;
    }

    public DroneEntity markDeliveredPackage() {
        if (!State.DELIVERING.equals(state)) {
            throw new DroneStateException("Not in DELIVERING state");
        }
        State oldState = this.state;
        this.state = State.DELIVERED;
        this.packageEntity.setPackageInfo(null);
        this.andEvent(DroneEventBuilder.droneStateChanged(this, oldState));
        return this;
    }

    public DroneEntity startReturningDrone() {
        if (!State.DELIVERED.equals(state)) {
            throw new DroneStateException("Not in DELIVERED state");
        }
        State oldState = this.state;
        this.state = State.RETURNING;
        this.andEvent(DroneEventBuilder.droneStateChanged(this, oldState));
        return this;
    }

    public DroneEntity markReturningDrone() {
        if (!State.RETURNING.equals(state)) {
            throw new DroneStateException("Not in RETURNING state");
        }
        State oldState = this.state;
        this.state = State.IDLE;
        this.andEvent(DroneEventBuilder.droneStateChanged(this, oldState));
        return this;
    }

    public PackageInfo getLoadedPackage() {
        if (!(State.LOADED.equals(this.getState()) || State.DELIVERING.equals(this.getState()))) {
            throw new DroneNotLoadedException(ErrorCodes.DRONE_NOT_LOADED_WITH_PACKAGE);
        }

        PackageInfo packageInfo = this.getPackageEntity().getPackageInfo();
        if (packageInfo == null || Objects.isNull(packageInfo.packageName())) {
            throw new DroneNotLoadedException(ErrorCodes.DRONE_NOT_LOADED_WITH_PACKAGE);
        }
        return packageInfo;
    }
}

