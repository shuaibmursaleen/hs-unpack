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

    
    @Data
    public static class NestedValue {
        private boolean nestedValue;
        private String value;
        private String percentage;
        private String percentageOf;
        private String msrpPercentage;
        private String amount;
        private String amount1;
    }

    @Data
    public static class Duty {
        private NestedValue ap;
        private NestedValue ad;
        private NestedValue bn;
        private NestedValue gt;
        private NestedValue in;
        private NestedValue pk;
        private NestedValue sa;
        private NestedValue sf;
        private NestedValue sd;
        private NestedValue sg;
    }

    @Data
    public static class SgDuty {
        private NestedValue gen;
        private NestedValue sg;
    }
}
