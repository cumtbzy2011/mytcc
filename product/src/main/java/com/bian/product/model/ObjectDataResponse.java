package com.bian.product.model;

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
