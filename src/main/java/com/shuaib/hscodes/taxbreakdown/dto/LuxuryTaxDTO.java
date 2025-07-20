package com.shuaib.hscodes.taxbreakdown.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LuxuryTaxDTO {
    private String freeThreshhold;
    private String rateAfterThreshhold;
}
