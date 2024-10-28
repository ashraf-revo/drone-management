package com.asrevo.drone.management.service;

import com.asrevo.drone.management.domain.DroneEntity;
import com.asrevo.drone.management.domain.Serial;
import com.asrevo.drone.management.domain.State;
import com.asrevo.drone.management.dto.DroneDto;
import com.asrevo.drone.management.dto.RegisterDroneRequest;
import com.asrevo.drone.management.mappers.DroneMapper;
import com.asrevo.drone.management.mappers.DroneMapperImpl;
import com.asrevo.drone.management.repository.DroneRepository;
import com.asrevo.drone.management.service.impl.DroneServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Tag("UnitTest")
class DroneServiceUnitTest {
    @Mock
    private DroneRepository droneRepository;
    private final DroneMapper droneMapper = new DroneMapperImpl();
    @InjectMocks
    private DroneServiceImpl droneService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        ReflectionTestUtils.setField(droneService, "droneMapper", droneMapper);
    }

    @Test
    void shouldAbleToFindAllDrones() {
        List<DroneEntity> t = List.of(new DroneEntity());
        Mockito.when(droneRepository.findAllByQuery()).thenReturn(t);
        List<DroneDto> result = droneService.findAll();
        assertThat(result, is(notNullValue()));
        assertThat(result, hasSize(t.size()));
    }

    @Test
    void shouldAbleToRegisterNewDrone() {
        String serialStr = "F".repeat(100);
        RegisterDroneRequest request = new RegisterDroneRequest(serialStr, 100, 200, 300, 400, 90f, 600);
        Mockito.when(droneRepository.findBySerial(new Serial(serialStr))).thenReturn(Optional.empty());
        Mockito.when(droneRepository.save(Mockito.any(DroneEntity.class))).then(AdditionalAnswers.returnsFirstArg());
        DroneDto result = droneService.registerNewDrone(request);
        assertThat(result, is(notNullValue()));
        assertThat(result.id(), is(notNullValue()));
        assertThat(result.state(), is(equalTo(State.IDLE)));
    }
}