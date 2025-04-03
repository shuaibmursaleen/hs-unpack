package com.shuaib.hscodes.taxbreakdown.model;

import lombok.Data;

@Data
public class SgDutyDTO {
    private Object gen;
    private Object sg;

    public SgDutyDTO(Object gen, Object sg) {
        this.gen = gen;
        this.sg = sg;
    }
}
