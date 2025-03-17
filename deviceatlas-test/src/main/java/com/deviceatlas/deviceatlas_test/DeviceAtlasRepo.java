package com.deviceatlas.deviceatlas_test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceAtlasRepo extends JpaRepository<DeviceAtlasProperties, Long> {
    
}
