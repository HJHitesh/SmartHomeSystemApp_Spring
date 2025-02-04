package com.hitesh.smartHomeAutomationSystem.model;

import org.springframework.stereotype.Component;

@Component
public class Device {
    private String id;
    private String name;
    private String type; // e.g., "light", "thermostat", "fan"
    private boolean status; // true = ON, false = OFF

    public Device() {}

    public Device(String id, String name, String type, boolean status) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.status = status;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }

    @Override
    public String toString() {
        return "Device{id='" + id + "', name='" + name + "', type='" + type + "', status=" + status + "}";
    }
}

