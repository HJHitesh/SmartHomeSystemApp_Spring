package com.hitesh.smartHomeAutomationSystem.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hitesh.smartHomeAutomationSystem.model.Schedule;

import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class ScheduleRepository {
    private final String FILE_PATH = "src/main/resources/persistence/schedules.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Schedule> findAll() {
        try {
            return objectMapper.readValue(new File(FILE_PATH), new TypeReference<List<Schedule>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Error reading schedules.json", e);
        }
    }

    public Optional<Schedule> findById(String id) {
        return findAll().stream().filter(schedule -> schedule.getId().equals(id)).findFirst();
    }

    public void save(Schedule schedule) {
        List<Schedule> schedules = findAll();
        schedules.removeIf(s -> s.getId().equals(schedule.getId()));
        schedules.add(schedule);
        writeToFile(schedules);
    }

    private void writeToFile(List<Schedule> schedules) {
        try {
            objectMapper.writeValue(new File(FILE_PATH), schedules);
        } catch (IOException e) {
            throw new RuntimeException("Error writing to schedules.json", e);
        }
    }
}

