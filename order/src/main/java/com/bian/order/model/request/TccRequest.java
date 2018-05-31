package com.bian.order.model.request;

import com.bian.common.model.vo.VoParticipant;
import lombok.Data;

import java.util.List;

@Data
public class TccRequest {
    List<VoParticipant> participantLinks;
}
