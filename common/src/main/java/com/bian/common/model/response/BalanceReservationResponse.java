package com.bian.common.model.response;

import com.bian.common.model.vo.Participant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BalanceReservationResponse extends RestfulResponse {

    Participant participant;
}
