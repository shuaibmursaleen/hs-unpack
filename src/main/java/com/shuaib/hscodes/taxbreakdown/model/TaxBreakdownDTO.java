package com.shuaib.hscodes.taxbreakdown.model;

import lombok.Data;

@Data
public class TaxBreakdownDTO {
    private String id;
    private String hsHeading;
    private String hsCode;
    private String description;
    private String unit;
    private String iclSlsi;
    private Duty prefDuty;
    private NestedValue genDuty;
    private NestedValue vat;
    private NestedValue palGen;
    private SgDuty pal;
    private NestedValue cessGen;
    private SgDuty cess;
    private NestedValue excise;
    private NestedValue surcharge;
    private NestedValue sscl;
    private NestedValue scl;

    public TaxBreakdownDTO(TaxBreakdown taxBreakdown){
        this.id = taxBreakdown.getId();
        this.hsHeading = taxBreakdown.getHsHeading();
        this.hsCode = taxBreakdown.getHsCode();
        this.description = taxBreakdown.getDescription();
        this.unit = taxBreakdown.getUnit();
        this.iclSlsi = taxBreakdown.getIclSlsi();
        this.prefDuty = taxBreakdown.getPrefDuty();
        this.genDuty = taxBreakdown.getGenDuty();
        this.vat = taxBreakdown.getVat();
        this.palGen = taxBreakdown.getPalGen();
        this.pal = taxBreakdown.getPal();
        this.cessGen = taxBreakdown.getCessGen();
        this.cess = taxBreakdown.getCess();
        this.excise = taxBreakdown.getExcise();
        this.surcharge = taxBreakdown.getSurcharge();
        this.sscl = taxBreakdown.getSscl();
        this.scl = taxBreakdown.getScl();
    }
}
