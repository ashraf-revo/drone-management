package com.asrevo.drone.management.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "drone_package")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DronePackageEntity extends AbstractAggregateRoot<DronePackageEntity> {
    @Id
    private DroneId id;

    @Embedded(onEmpty = Embedded.OnEmpty.USE_NULL)
    private PackageInfo packageInfo;

    public static DronePackageEntity createEmptyPackage(DroneId droneId) {
        DronePackageEntity entity = new DronePackageEntity();
        entity.setId(droneId);
        entity.setPackageInfo(null);
        return entity;
    }
}
