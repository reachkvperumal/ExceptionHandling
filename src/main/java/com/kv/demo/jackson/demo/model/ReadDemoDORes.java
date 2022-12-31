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

    public ReadDemoDORes(String name, String accessKey, String eventName, String eventId) {
        this.name = name;
        this.accessKey = accessKey;
        this.eventName = eventName;
        this.eventId = eventId;
    }

    public String getName() {
        return name;
    }


    public String getAccessKey() {
        return accessKey;
    }


    public String getEventName() {
        return eventName;
    }


    public String getEventId() {
        return eventId;
    }

}
