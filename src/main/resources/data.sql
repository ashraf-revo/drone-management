INSERT INTO drone.drone (id, serial, state, version, battery_capacity, wight_limit, light_weight, heavy_weight,
                         middle_weight, cruiser_weight)
VALUES ('2bae23c6-16cf-4e48-9f15-9ced0e3f250a',
        'AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA',
        'IDLE',
        1,
        45,
        750,
        2000,
        2750,
        2500,
        500)
on conflict do nothing;

INSERT INTO drone.drone (id, serial, state, version, battery_capacity, wight_limit, light_weight, heavy_weight,
                         middle_weight, cruiser_weight)
VALUES ('79182f41-ad53-40fe-889e-b213bcd7c1f5',
        'BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB',
        'LOADED',
        1,
        90,
        750,
        2000,
        2750,
        2500,
        500)
on conflict do nothing;

INSERT INTO drone.drone (id, serial, state, version, battery_capacity, wight_limit, light_weight, heavy_weight,
                         middle_weight, cruiser_weight)
VALUES ('4a8158af-e8cc-466f-99aa-da091da9df19',
        'cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc',
        'LOADING',
        1,
        60,
        200,
        2000,
        2750,
        2500,
        500)
on conflict do nothing;

INSERT INTO drone.drone (id, serial, state, version, battery_capacity, wight_limit, light_weight, heavy_weight,
                         middle_weight, cruiser_weight)
VALUES ('fd3465ef-8247-4ffb-a55c-dde268c8314a',
        'DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD',
        'IDLE',
        1,
        15,
        750,
        2000,
        2750,
        2500,
        500)
on conflict do nothing;


INSERT INTO drone.drone_package(id, package_name, weight, code, image_url)
VALUES ('2bae23c6-16cf-4e48-9f15-9ced0e3f250a',
        null,
        null,
        null,
        null) on conflict do nothing ;

INSERT INTO drone.drone_package(id, package_name, weight, code, image_url)
VALUES ('79182f41-ad53-40fe-889e-b213bcd7c1f5',
        'Package_Name-01',
        200,
        'PKG-AE0101223',
        'URL') on conflict do nothing ;

INSERT INTO drone.drone_package(id, package_name, weight, code, image_url)
VALUES ('4a8158af-e8cc-466f-99aa-da091da9df19',
        null,
        null,
        null,
        null) on conflict do nothing ;

INSERT INTO drone.drone_package(id, package_name, weight, code, image_url)
VALUES ('fd3465ef-8247-4ffb-a55c-dde268c8314a',
        null,
        null,
        null,
        null) on conflict do nothing ;
