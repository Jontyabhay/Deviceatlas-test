package com.deviceatlas.deviceatlas_test;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "device_atlas")
public class DeviceAtlasProperties {   // Entity class to store the device properties
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @Column(name = "primary_hardware_type")
    private String primaryHardwareType;
    @Column(name = "os_version")
    private String osVersion;
    @Column(name = "vendor")
    private String vendor;
    @Column(name = "browser_version")
    private String browserVersion;
    @Column(name = "browser_name")
    private String browserName;
    @Column(name = "model")
    private String model;
    @Column(name = "os_name")
    private String osName;
    @Column(name = "browser_rendering_engine")
    private String browserRenderingEngine;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPrimaryHardwareType() {
        return primaryHardwareType;
    }
    public void setPrimaryHardwareType(String primaryHardwareType) {
        this.primaryHardwareType = primaryHardwareType;
    }
    public String getOsVersion() {
        return osVersion;
    }
    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }
    public String getVendor() {
        return vendor;
    }
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
    public String getBrowserVersion() {
        return browserVersion;
    }
    public void setBrowserVersion(String browserVersion) {
        this.browserVersion = browserVersion;
    }
    public String getBrowserName() {
        return browserName;
    }
    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getOsName() {
        return osName;
    }
    public void setOsName(String osName) {
        this.osName = osName;
    }
    public String getBrowserRenderingEngine() {
        return browserRenderingEngine;
    }
    public void setBrowserRenderingEngine(String browserRenderingEngine) {
        this.browserRenderingEngine = browserRenderingEngine;
    }
}