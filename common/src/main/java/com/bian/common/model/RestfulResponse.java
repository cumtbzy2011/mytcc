package com.bian.common.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RestfulResponse implements Response {

    public static final int DEFAULT_OK = 20000;

    @JsonProperty("code")
    private int code = DEFAULT_OK; //状态码
}
