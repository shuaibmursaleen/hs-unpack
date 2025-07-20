package com.shuaib.hscodes.taxbreakdown.entity;

import lombok.Data;

@Data
public class LuxuryTax {
    private String freeThreshhold;
    private String rateAfterThreshhold;
}
