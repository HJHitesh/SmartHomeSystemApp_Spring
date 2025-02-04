package com.hitesh.smartHomeAutomationSystem.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hitesh.smartHomeAutomationSystem.model.Schedule;
import com.hitesh.smartHomeAutomationSystem.service.ScheduleService;

@Controller
@RequestMapping("/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping
    public String getSchedules(Model model) {
        List<Schedule> schedules = scheduleService.getAllSchedules();
        model.addAttribute("schedules", schedules);
        return "schedules";
    }

    @PostMapping("/add")
    public String addSchedule(@ModelAttribute Schedule schedule) {
        scheduleService.addSchedule(schedule);
        return "redirect:/schedules";
    }
}

