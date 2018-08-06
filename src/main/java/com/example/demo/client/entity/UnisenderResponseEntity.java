package com.example.demo.client.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@ToString
public class UnisenderResponseEntity<T> {

    @JsonProperty("result")
    private T result;

    @JsonProperty("error")
    private String error;

    @JsonProperty("code")
    private String code;


}
