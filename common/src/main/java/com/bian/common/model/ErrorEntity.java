package com.bian.common.model;

import com.bian.common.RestStatus;
import com.bian.common.model.response.Response;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ErrorEntity implements Response {
    int code;

    String msg;

    Object details;

    public ErrorEntity(RestStatus statusCodes) {
        this(statusCodes, null);
    }

    public ErrorEntity(RestStatus statusCodes, Object details) {
        this.code = statusCodes.code();
        this.msg = statusCodes.message();
        if (details != null) {
            this.details = details;
        }
    }
}
