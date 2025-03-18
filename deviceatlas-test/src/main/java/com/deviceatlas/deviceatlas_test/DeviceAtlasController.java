package com.deviceatlas.deviceatlas_test;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceAtlasController {

    private final DeviceAtlasService deviceAtlasService;

    @Autowired
    private DeviceAtlasRepo deviceAtlasRepo;

    public DeviceAtlasController(DeviceAtlasService deviceAtlasService) {
        this.deviceAtlasService = deviceAtlasService;
    }

    @GetMapping("/")
    public List<String> detectDeviceProperties() {
        return deviceAtlasService.processandstoreUserAgents();
    }

    @GetMapping("/tablets")
    public List<DeviceAtlasProperties> getTablets() {
        return deviceAtlasRepo.findAll().stream()
                .filter(device -> "tablet".equalsIgnoreCase(device.getPrimaryHardwareType()))
                .sorted((d1, d2) -> d1.getOsVersion().compareTo(d2.getOsVersion()))
                .collect(Collectors.toList());
    }
}
