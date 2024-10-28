package com.asrevo.drone.management.api.v1;

import com.asrevo.drone.management.domain.DroneId;
import com.asrevo.drone.management.domain.Model;
import com.asrevo.drone.management.domain.Serial;
import com.asrevo.drone.management.domain.State;
import com.asrevo.drone.management.dto.DroneDto;
import com.asrevo.drone.management.service.DroneService;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DroneApi.class)
@Tag("UnitTest")
class DroneApiUnitTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DroneService droneService;

    @Test
    void shouldCallServiceToFindAllDrones() throws Exception {
        List<DroneDto> t = List.of();
        Mockito.when(droneService.findAll()).thenReturn(t);
        this.mockMvc.perform(get("/api/v1/drone/find-all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.*", hasSize(t.size())));
    }

    @Test
    void shouldCallServiceToFindDroneById() throws Exception {
        DroneDto r = new DroneDto(new DroneId(UUID.randomUUID().toString()),new Serial("A".repeat(100)),new Model(100,200,300,400), State.IDLE,60F,600,null);
        Mockito.when(droneService.findOne(r.id())).thenReturn(Optional.of(r));
        this.mockMvc.perform(get("/api/v1/drone/find-one?id="+ r.id().id()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id.id", equalTo(r.id().id())));
    }
}