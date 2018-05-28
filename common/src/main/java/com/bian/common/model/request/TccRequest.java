package com.bian.common.model.request;

import com.bian.common.model.vo.Participant;
import lombok.Data;

import java.util.List;

@Data
public class TccRequest {
    List<Participant> participantLinks;
}
