package com.asrevo.drone.management.service;

import com.asrevo.drone.management.dto.DroneDto;
import com.asrevo.drone.management.mappers.DroneMapperImpl;
import com.asrevo.drone.management.service.impl.DroneDispatchServiceImpl;
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
@Import({DroneDispatchServiceImpl.class, DroneMapperImpl.class})
@Tag("IntegrationTest")
class DroneDispatchServiceIntegrationTest {

    @Autowired
    private DroneDispatchService droneDispatchService;

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> pg =
            new PostgreSQLContainer<>("postgres:15");

  @Test
    void shouldAbleToFindAllForLoading() {
        List<DroneDto> all = droneDispatchService.findAllForLoading();
        assertThat(all, is(notNullValue()));
        assertThat(all, hasSize(greaterThan(0)));
    }
}