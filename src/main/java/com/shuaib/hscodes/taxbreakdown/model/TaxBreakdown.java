package com.shuaib.hscodes.taxbreakdown.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Data
@Document("hs_codes")
public class TaxBreakdown {

    @Id
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
}
