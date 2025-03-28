package com.deviceatlas.deviceatlas_test;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeviceAtlasController {  // Controller class to handle requests

    private final DeviceAtlasService deviceAtlasService;

    @Autowired
    private DeviceAtlasRepo deviceAtlasRepo;

    public DeviceAtlasController(DeviceAtlasService deviceAtlasService) {
        this.deviceAtlasService = deviceAtlasService;
    }

    @GetMapping("/")
    @ResponseBody
    public List<String> detectDeviceProperties() {
        return deviceAtlasService.processandstoreUserAgents();
    }

    @GetMapping("/tablets")
    public String getTablets(Model model) { // Backend function to get tablets
        List<DeviceAtlasProperties> tablets = deviceAtlasRepo.findAll().stream()
                .filter(device -> "tablet".equalsIgnoreCase(device.getPrimaryHardwareType()))
                .sorted((d1, d2) -> d1.getOsVersion().compareTo(d2.getOsVersion()))
                .collect(Collectors.toList());
        model.addAttribute("tablets", tablets);
        return "tablet"; // This maps to src/main/resources/templates/tablet.html
    }
}
