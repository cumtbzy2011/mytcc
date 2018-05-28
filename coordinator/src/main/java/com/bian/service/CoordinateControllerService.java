package com.bian.service;

import com.bian.common.model.request.TccRequest;

public interface CoordinateControllerService {
    void confirm(TccRequest request);

    void cancel(TccRequest request);
}
