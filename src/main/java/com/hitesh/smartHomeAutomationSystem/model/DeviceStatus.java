package com.hitesh.smartHomeAutomationSystem.model;

import org.springframework.stereotype.Component;

@Component
public class DeviceStatus {
    private String deviceId;
    private boolean status; // true = ON, false = OFF

    public DeviceStatus() {}

    public DeviceStatus(String deviceId, boolean status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    public String getDeviceId() { return deviceId; }
    public void setDeviceId(String deviceId) { this.deviceId = deviceId; }

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }

    @Override
    public String toString() {
        return "DeviceStatus{deviceId='" + deviceId + "', status=" + status + "}";
    }
}
