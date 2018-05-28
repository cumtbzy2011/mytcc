package com.bian.common;

import com.bian.common.model.vo.Participant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TccErrorResponse {
    private List<Participant> participantLinks;
}
