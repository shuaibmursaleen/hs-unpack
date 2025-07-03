package com.shuaib.hscodes.taxbreakdown.dto;

import com.shuaib.hscodes.taxbreakdown.entity.Duty;
import com.shuaib.hscodes.taxbreakdown.entity.SgDuty;
import com.shuaib.hscodes.taxbreakdown.entity.TaxBreakdown;

import lombok.Data;


@Data
public class TaxBreakdownDTO {
    private String id;
    private String hsHeading;
    private String hsCode;
    private String description;
    private String unit;
    private String iclSlsi;
    private DutyDTO prefDuty;
    private String genDuty;
    private String vat;
    private Object pal;
    private Object cess;
    private String excise;
    private String surcharge;
    private String sscl;
    private String scl;

    public TaxBreakdownDTO(TaxBreakdown taxBreakdown){
        this.id = taxBreakdown.getId();
        this.hsHeading = taxBreakdown.getHsHeading();
        this.hsCode = taxBreakdown.getHsCode();
        this.description = taxBreakdown.getDescription();
        this.unit = taxBreakdown.getUnit();
        this.iclSlsi = taxBreakdown.getIclSlsi();
        this.prefDuty = setPrefDutyValues(taxBreakdown.getPrefDuty());
        this.genDuty = setTaxValues(taxBreakdown.getGenDuty());
        this.vat = setTaxValues(taxBreakdown.getVat());

        if (taxBreakdown.getPalGen() == null) {
            this.pal = setSgDutyValues(taxBreakdown.getPal());
        }
        else this.pal = setTaxValues(taxBreakdown.getPalGen());

        if (taxBreakdown.getCessGen() == null) {
            this.cess = setSgDutyValues(taxBreakdown.getCess());
        }
        else this.cess = setTaxValues(taxBreakdown.getCessGen());

        this.excise = setTaxValues(taxBreakdown.getExcise());
        this.surcharge = setTaxValues(taxBreakdown.getSurcharge());
        this.sscl = setTaxValues(taxBreakdown.getSscl());
        this.scl = setTaxValues(taxBreakdown.getScl());
    }

    private static String setTaxValues(String value) {
        if (value == null) {
            return null;
        }
        else return value;
    }

    private static DutyDTO setPrefDutyValues(Duty prefDuty) {
        return new DutyDTO(setTaxValues(prefDuty.getAp()), setTaxValues(prefDuty.getAd()), setTaxValues(prefDuty.getBn()), setTaxValues(prefDuty.getGt()), setTaxValues(prefDuty.getIn()), setTaxValues(prefDuty.getPk()), setTaxValues(prefDuty.getSa()), setTaxValues(prefDuty.getSf()), setTaxValues(prefDuty.getSd()), setTaxValues(prefDuty.getSg()));
    }

    private static SgDutyDTO setSgDutyValues(SgDuty duty) {
        return new SgDutyDTO(setTaxValues(duty.getGen()), setTaxValues(duty.getSg()));
    }
}
