package com.shuaib.hscodes.taxbreakdown.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Document("hs_codes")
@Data
public class TaxBreakdown {

    @Id
    private String id;
    private String hsHeading;
    private String hsCode;
    private String description;
    private String unit;
    private String iclSlsi;
    private Duty prefDuty;
    private String genDuty;
    private String vat;
    private String palGen;
    private SgDuty pal;
    private String cessGen;
    private SgDuty cess;
    private String excise;
    private String surcharge;
    private String sscl;
    private String scl;
    private LuxuryTax luxuryTax;
}
