package com.example.demo.client.entity;

import com.example.demo.client.WebHookUserEventData;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WebHookEvent {

    @JsonProperty("event_name")
    private String eventName;

    @JsonProperty("event_time")
    private String eventTime;

    @JsonProperty("data")
    private WebHookUserEventData data;


    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }


    @Override
    public String toString() {
        return "WebHookEvent{" +
                "eventName='" + eventName + '\'' +
                ", eventTime='" + eventTime + '\'' +
                '}';
    }
}

