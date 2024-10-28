package com.asrevo.drone.management;

import org.springframework.boot.SpringApplication;

public class TestDroneManagementApplication {

	public static void main(String[] args) {
		SpringApplication.from(DroneManagementApplication::main).with(TestcontainersConfiguration.class).run(args);
	}
}
