package com.hitesh.smartHomeAutomationSystem.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hitesh.smartHomeAutomationSystem.controller.DeviceController;
import com.hitesh.smartHomeAutomationSystem.model.Device;
import com.hitesh.smartHomeAutomationSystem.repository.DeviceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {
    private final DeviceRepository deviceRepository;
    
    Logger logger = LoggerFactory.getLogger(DeviceService.class);
    
    
    public DeviceService(DeviceRepository deviceRepository) {
    	logger.info("Object made DeviceRepository");
        this.deviceRepository = deviceRepository;
    }

    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    public Optional<Device> getDeviceById(String id) {
        return deviceRepository.findById(id);
    }

    public void toggleDevice(String id) {
        deviceRepository.findById(id).ifPresent(device -> {
            device.setStatus(!device.isStatus());
            deviceRepository.save(device);
        });
    }
}
