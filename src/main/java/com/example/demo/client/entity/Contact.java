package com.example.demo.client.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Contact {

    private String id;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Email")
    private String email;

}
