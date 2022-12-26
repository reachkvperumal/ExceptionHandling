package com.kv.demo.jackson.demo.model;


import java.io.Serial;
import java.io.Serializable;

public class ReadDemoDORes implements Serializable {

    @Serial
    private static final long serialVersionUID = 4603755132822488502L;

    private String name;
    private String accessKey;
    private String eventName;
    private String eventId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }
}
