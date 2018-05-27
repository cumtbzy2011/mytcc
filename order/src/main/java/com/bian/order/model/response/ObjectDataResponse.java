package com.bian.order.model.response;

import com.bian.common.model.RestfulResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObjectDataResponse<T> extends RestfulResponse {

    private T data;
}
