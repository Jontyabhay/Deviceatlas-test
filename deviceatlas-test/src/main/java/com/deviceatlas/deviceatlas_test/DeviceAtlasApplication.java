package com.deviceatlas.deviceatlas_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeviceAtlasApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeviceAtlasApplication.class, args);
		System.out.println("DeviceAtlasApplication started successfully");
		System.out.println("Please open your browser and navigate to http://localhost:8080/");
	}

}
