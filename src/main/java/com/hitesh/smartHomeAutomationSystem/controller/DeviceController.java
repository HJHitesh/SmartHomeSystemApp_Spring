package com.hitesh.smartHomeAutomationSystem.controller;


import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hitesh.smartHomeAutomationSystem.model.Device;
import com.hitesh.smartHomeAutomationSystem.service.DeviceService;

@Controller
@RequestMapping("/devices")
public class DeviceController {
    
    private final DeviceService deviceService;
    
    Logger logger = LoggerFactory.getLogger(DeviceController.class);
    
    DeviceController(DeviceService device){
    	this.deviceService = device;
    }


    @GetMapping
    public String getDevices(Model model) {
        List<Device> devices = deviceService.getAllDevices();
        model.addAttribute("devices", devices);
        return "devices"; 
    }

    @PostMapping("/toggle/{id}")
    public String toggleDevice(@PathVariable String id) {
        deviceService.toggleDevice(id);
        return "redirect:/devices";
    }
}

