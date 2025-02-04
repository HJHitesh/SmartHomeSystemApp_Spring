package com.hitesh.smartHomeAutomationSystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.hitesh.smartHomeAutomationSystem.controller.DeviceController;
import com.hitesh.smartHomeAutomationSystem.repository.DeviceRepository;
import com.hitesh.smartHomeAutomationSystem.service.DeviceService;

@SpringBootApplication
public class SmartHomeAutomationSystemApplication {
	
	Logger logger = LoggerFactory.getLogger(SmartHomeAutomationSystemApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SmartHomeAutomationSystemApplication.class, args);
	}
	
	@Bean
	public DeviceRepository deviceRepository() {
		return new DeviceRepository();
	}

	@Bean
	public DeviceService deviceService(DeviceRepository device) {
		logger.info("Calling  made DeviceService **");
		return new DeviceService(device);
	};

}
