package com.hitesh.smartHomeAutomationSystem.model;

import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class User {
    private String id;
    private String name;
    private List<String> devices; // List of device IDs owned by the user

    public User() {}

    public User(String id, String name, List<String> devices) {
        this.id = id;
        this.name = name;
        this.devices = devices;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<String> getDevices() { return devices; }
    public void setDevices(List<String> devices) { this.devices = devices; }

    @Override
    public String toString() {
        return "User{id='" + id + "', name='" + name + "', devices=" + devices + "}";
    }
}
