package com.shuaib.hscodes.taxbreakdown.model;

import lombok.Data;

@Data
public class DutyDTO {
    private Object ap;
    private Object ad;
    private Object bn;
    private Object gt;
    private Object in;
    private Object pk;
    private Object sa;
    private Object sf;
    private Object sd;
    private Object sg;

    public DutyDTO(Object ap, Object ad, Object bn, Object gt, Object in, Object pk, Object sa, Object sf, Object sd, Object sg) {
        this.ap = ap;
        this.ad = ad;
        this.bn = bn;
        this.gt = gt;
        this.in = in;
        this.pk = pk;
        this.sa = sa;
        this.sf = sf;
        this.sd = sd;
        this.sg = sg;
    }
}
