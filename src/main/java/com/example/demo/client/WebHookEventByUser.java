package com.example.demo.client;

import com.example.demo.client.entity.WebHookEvent;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WebHookEventByUser {

    private String login;

    @JsonProperty("events")
    private WebHookEvent event;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public WebHookEvent getEvent() {
        return event;
    }

    public void setEvent(WebHookEvent event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "WebHookEventByUser{" +
                "login='" + login + '\'' +
                ", event=" + event +
                '}';
    }
}
