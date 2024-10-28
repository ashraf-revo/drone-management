package com.asrevo.drone.management.config;

import com.asrevo.drone.management.domain.DroneHistoryId;
import com.asrevo.drone.management.domain.DroneId;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class JdbcConfig extends AbstractJdbcConfiguration {
    @Override
    public JdbcCustomConversions jdbcCustomConversions() {
        List<Converter<?, ?>> converters = new ArrayList<>();
        converters.add(new Converter<DroneId, String>() {
            @Override
            public String convert(DroneId source) {
                return source.id();
            }
        });
        converters.add(new Converter<DroneHistoryId, String>() {
            @Override
            public String convert(DroneHistoryId source) {
                return source.id();
            }
        });
        return new JdbcCustomConversions(converters);
    }

}
