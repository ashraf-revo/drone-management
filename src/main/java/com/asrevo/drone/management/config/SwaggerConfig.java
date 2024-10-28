package com.asrevo.drone.management.config;

import com.asrevo.drone.management.domain.DroneId;
import org.springdoc.core.utils.SpringDocUtils;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    static {
        SpringDocUtils.getConfig().replaceWithClass(DroneId.class, String.class);
    }
}
