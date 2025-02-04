package com.hitesh.smartHomeAutomationSystem.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hitesh.smartHomeAutomationSystem.model.Device;

import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class DeviceRepository {
    private final String FILE_PATH = "src/main/resources/persistence/devices.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Device> findAll() {
        try {
            return objectMapper.readValue(new File(FILE_PATH), new TypeReference<List<Device>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Error reading devices.json", e);
        }
    }

    public Optional<Device> findById(String id) {
        return findAll().stream().filter(device -> device.getId().equals(id)).findFirst();
    }

    public void save(Device device) {
        List<Device> devices = findAll();
        List<Device> updatedDevices = devices.stream()
                .map(d -> d.getId().equals(device.getId()) ? device : d)
                .collect(Collectors.toList());

        writeToFile(updatedDevices);
    }

    private void writeToFile(List<Device> devices) {
        try {
            objectMapper.writeValue(new File(FILE_PATH), devices);
        } catch (IOException e) {
            throw new RuntimeException("Error writing to devices.json", e);
        }
    }
}

