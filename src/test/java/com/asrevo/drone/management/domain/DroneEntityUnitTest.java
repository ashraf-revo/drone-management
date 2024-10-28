package com.asrevo.drone.management.domain;

import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@Tag("UnitTest")
class DroneEntityUnitTest {
    @Test
    void shouldAbleToCreateDroneEntity() {
        Serial serial = new Serial("A".repeat(100));
        Model model = new Model(100, 200, 300, 400);
        float batteryCapacity = 50F;
        int wightLimit = 500;
        DroneEntity entity = DroneEntity.newDrone(serial, model, batteryCapacity, wightLimit);
        assertThat(entity, is(notNullValue()));
        assertThat(entity.getId(), is(notNullValue()));
        assertThat(entity.getSerial(), is(serial));
        assertThat(entity.getModel(), is(model));
        assertThat(entity.getBatteryCapacity(), is(batteryCapacity));
        assertThat(entity.getWightLimit(), is(wightLimit));
    }

    @Test
    void shouldAbleToLoadingDroneIfInIdealState() {
        Serial serial = new Serial("A".repeat(100));
        Model model = new Model(100, 200, 300, 400);
        float batteryCapacity = 50F;
        int wightLimit = 500;
        DroneEntity entity = DroneEntity.newDrone(serial, model, batteryCapacity, wightLimit);
        DroneEntity result = entity.loadingDrone();
        assertThat(result, is(notNullValue()));
        assertThat(result.getState(), is(notNullValue()));
        assertThat(result.getState(), is(equalTo(State.LOADING)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"LOADING", "LOADED", "DELIVERING", "DELIVERED", "RETURNING"})
    void shouldNotAbleToLoadingDroneIfNotInIdealState(String state) {
        Serial serial = new Serial("A".repeat(100));
        Model model = new Model(100, 200, 300, 400);
        float batteryCapacity = 50F;
        int wightLimit = 500;
        DroneEntity entity = DroneEntity.newDrone(serial, model, batteryCapacity, wightLimit);
        entity.setState(State.valueOf(state));
        Assert.assertThrows(DroneStateException.class, entity::loadingDrone);
    }

    @ParameterizedTest
    @ValueSource(floats = {10f, 20f, 22f})
    void shouldNotAbleToLoadingDroneIfNotBatteryCapacityLessThan25(Float batteryCapacity) {
        Serial serial = new Serial("A".repeat(100));
        Model model = new Model(100, 200, 300, 400);
        int wightLimit = 500;
        DroneEntity entity = DroneEntity.newDrone(serial, model, batteryCapacity, wightLimit);
        Assert.assertThrows(DroneStateException.class, entity::loadingDrone);
    }

    @ParameterizedTest
    @ValueSource(floats = {25, 30f, 62f})
    void shouldAbleToLoadingDroneIfNotBatteryCapacityGreeterThan25(Float batteryCapacity) {
        Serial serial = new Serial("A".repeat(100));
        Model model = new Model(100, 200, 300, 400);
        int wightLimit = 500;
        DroneEntity entity = DroneEntity.newDrone(serial, model, batteryCapacity, wightLimit);
        DroneEntity result = entity.loadingDrone();
        assertThat(result, is(notNullValue()));
        assertThat(result.getState(), is(notNullValue()));
        assertThat(result.getState(), is(equalTo(State.LOADING)));
    }

}