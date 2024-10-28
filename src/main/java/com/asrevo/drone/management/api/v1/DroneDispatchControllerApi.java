package com.asrevo.drone.management.api.v1;

import com.asrevo.drone.management.domain.DroneId;
import com.asrevo.drone.management.domain.PackageInfo;
import com.asrevo.drone.management.dto.DroneDto;
import com.asrevo.drone.management.service.DroneDispatchService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/drone-dispatch-controller")
@AllArgsConstructor
@Slf4j
public class DroneDispatchControllerApi {
    private final DroneDispatchService droneDispatchService;

    @PostMapping(value = "step1-loading-drone", params = {"droneId"})
    public void loadingDrone(@RequestParam DroneId droneId) {
        droneDispatchService.loadingDrone(droneId);
    }

    @PostMapping(value = "step2-loaded-package", params = {"droneId"})
    public void loadedPackage(@RequestParam DroneId droneId, @RequestBody PackageInfo packageInfo) {
        droneDispatchService.loadedPackage(droneId, packageInfo);
    }

    @PostMapping(value = "step3-delivering-package", params = {"droneId"})
    public void startDeliveringPackage(@RequestParam DroneId droneId) {
        droneDispatchService.startDeliveringPackage(droneId);
    }

    @PostMapping(value = "step4-delivered-package", params = {"droneId"})
    public void markDeliveredPackage(@RequestParam DroneId droneId) {
        droneDispatchService.markDeliveredPackage(droneId);
    }

    @PostMapping(value = "step5-returning-drone", params = {"droneId"})
    public void startReturningDrone(@RequestParam DroneId droneId) {
        droneDispatchService.startReturningDrone(droneId);
    }

    @PostMapping(value = "step6-returned-drone", params = {"droneId"})
    public void markReturnedDrone(@RequestParam DroneId droneId) {
        droneDispatchService.markReturnedDrone(droneId);
    }

    @GetMapping("find-all-for-loading")
    public List<DroneDto> findAllForLoading() {
        return droneDispatchService.findAllForLoading();
    }

    @GetMapping(value = "loaded-package-info", params = {"droneId"})
    public PackageInfo loadedPackageInfo(@RequestParam DroneId droneId) {
        return droneDispatchService.loadedPackageInfo(droneId);
    }

    @GetMapping(value = "battery-level", params = {"droneId"})
    public Map<String, String> batteryLevel(@RequestParam DroneId droneId) {
        return droneDispatchService.batteryLevel(droneId);
    }

    @GetMapping(value = "state", params = {"droneId"})
    public Map<String, String> state(@RequestParam DroneId droneId) {
        return droneDispatchService.state(droneId);
    }

}
