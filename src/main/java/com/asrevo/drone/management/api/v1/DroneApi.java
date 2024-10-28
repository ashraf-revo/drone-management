package com.asrevo.drone.management.api.v1;

import com.asrevo.drone.management.domain.DroneId;
import com.asrevo.drone.management.dto.DroneDto;
import com.asrevo.drone.management.dto.RegisterDroneRequest;
import com.asrevo.drone.management.service.DroneService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/drone")
@AllArgsConstructor
@Slf4j
public class DroneApi {
    private final DroneService droneService;

    @PostMapping("register")
    public DroneDto register(@RequestBody RegisterDroneRequest request) {
        return droneService.registerNewDrone(request);
    }

    @GetMapping("find-all")
    public List<DroneDto> findAll() {
        return droneService.findAll();
    }

    @GetMapping(value = "find-one", params = {"id"})
    public Optional<DroneDto> findOne(@RequestParam DroneId id) {
        return droneService.findOne(id);
    }
}
