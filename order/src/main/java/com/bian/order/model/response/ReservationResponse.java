package com.bian.order.model.response;


import com.bian.common.model.response.Response;
import com.bian.order.model.vo.Participant;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReservationResponse implements Response {

    Participant participantLink;
}
