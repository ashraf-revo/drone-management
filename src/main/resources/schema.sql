create schema if not exists drone;
create table if not exists drone.drone
(
    id               varchar(50),
    serial           varchar(100),
    state            varchar(20),
    version          integer,
    battery_capacity float4,
    wight_limit      integer,
    light_weight     integer,
    heavy_weight     integer,
    middle_weight    integer,
    cruiser_weight   integer,
    constraint drone_pk primary key (id),
    constraint drone_serial_unique unique (serial)
);

create table if not exists drone.drone_package
(
    id           varchar(50),
    package_name varchar(50),
    weight       integer,
    code         varchar(50),
    image_url    varchar(50),
    constraint drone_package_pk primary key (id),
    constraint drone_package_drone_fk foreign key (id) references drone.drone (id)

);

create table if not exists drone.drone_history
(
    id               varchar(50),
    battery_capacity float4,
    version          integer,
    drone_id varchar(50),
    constraint drone_history_pk primary key (id),
    constraint drone_history_drone_fk foreign key (drone_id) references drone.drone (id)
);
