package com.deviceatlas.deviceatlas_test;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceAtlasController {

    private final DeviceAtlasService deviceAtlasService;

    public DeviceAtlasController(DeviceAtlasService deviceAtlasService) {
        this.deviceAtlasService = deviceAtlasService;
    }

    @GetMapping("/")
    public List<String> detectDeviceProperties() {
        return deviceAtlasService.processandstoreUserAgents();
    }
}
