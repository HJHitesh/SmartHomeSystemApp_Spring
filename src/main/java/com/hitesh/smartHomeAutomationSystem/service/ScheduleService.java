package com.hitesh.smartHomeAutomationSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hitesh.smartHomeAutomationSystem.model.Schedule;
import com.hitesh.smartHomeAutomationSystem.repository.ScheduleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public Optional<Schedule> getScheduleById(String id) {
        return scheduleRepository.findById(id);
    }

    public void addSchedule(Schedule schedule) {
    	
    	
        List<Schedule> schedules = scheduleRepository.findAll();
        int newId = schedules.stream()
                             .mapToInt(s -> Integer.parseInt(s.getId()))
                             .max()
                             .orElse(5000) + 1; 
        
        scheduleRepository.save(schedule);
    }
}
