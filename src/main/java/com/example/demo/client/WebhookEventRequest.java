package com.example.demo.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WebhookEventRequest {

    private String auth;

    @JsonIgnoreProperties("events_by_user")
    private WebHookEventByUser[] events;

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public WebHookEventByUser[] getEvents() {
        return events;
    }

    public void setEvents(WebHookEventByUser[] events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "WebhookEventRequest{" +
                "auth='" + auth + '\'' +
                ", events=" + Arrays.toString(events) +
                '}';
    }
}
