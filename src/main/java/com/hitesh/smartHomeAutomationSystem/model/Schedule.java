package com.hitesh.smartHomeAutomationSystem.model;

import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@Component
public class Schedule {
    private String id;
    private String deviceId;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime time;
    private boolean action; // true = Turn ON, false = Turn OFF

    public Schedule() {}

    public Schedule(String id, String deviceId, LocalDateTime time, boolean action) {
        this.id = id;
        this.deviceId = deviceId;
        this.time = time;
        this.action = action;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getDeviceId() { return deviceId; }
    public void setDeviceId(String deviceId) { this.deviceId = deviceId; }

    public LocalDateTime getTime() { return time; }
    public void setTime(LocalDateTime time) { this.time = time; }

    public boolean isAction() { return action; }
    public void setAction(boolean action) { this.action = action; }

    @Override
    public String toString() {
        return "Schedule{id='" + id + "', deviceId='" + deviceId + "', time=" + time + ", action=" + action + "}";
    }
}

