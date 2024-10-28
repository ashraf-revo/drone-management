package com.asrevo.drone.management.service;

import com.asrevo.drone.management.dto.DroneDto;
import com.asrevo.drone.management.mappers.DroneMapperImpl;
import com.asrevo.drone.management.service.impl.DroneServiceImpl;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Testcontainers
@DataJdbcTest
@AutoConfigureTestDatabase(
        replace = AutoConfigureTestDatabase.Replace.NONE
)
@Import({DroneServiceImpl.class, DroneMapperImpl.class})
@Tag("IntegrationTest")
class DroneServiceIntegrationTest {
    @Autowired
    private DroneService droneService;

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> pg =
            new PostgreSQLContainer<>("postgres:15");

    @Test
    void shouldRetrieveAllPreLoadedDrones() {
        List<DroneDto> all = droneService.findAll();
        assertThat(all, is(notNullValue()));
        assertThat(all, hasSize(greaterThan(0)));
    }
}