package com.hitesh.smartHomeAutomationSystem.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DeviceLoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(DeviceLoggingAspect.class);

    @Before("execution(* com.hitesh.smartHomeAutomationSystem.service.DeviceService.toggleDevice(..))")
    public void logBeforeToggle(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        String deviceId = (args.length > 0) ? args[0].toString() : "Unknown";
        logger.info("Attempting to toggle device with ID: " + deviceId);
    }

    @After("execution(* com.hitesh.smartHomeAutomationSystem.service.DeviceService.toggleDevice(..))")
    public void logAfterToggle(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        String deviceId = (args.length > 0) ? args[0].toString() : "Unknown";
        logger.info("Device with ID " + deviceId + " has been toggled successfully.");
    }
}

