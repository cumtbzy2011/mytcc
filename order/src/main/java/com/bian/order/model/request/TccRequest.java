package com.bian.order.model.request;

import com.bian.order.model.vo.OrderParticipant;
import lombok.Data;

import java.util.List;

@Data
public class TccRequest {
    List<OrderParticipant> participantLinks;
}
