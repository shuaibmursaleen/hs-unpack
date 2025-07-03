package com.shuaib.hscodes.taxbreakdown.exception;

public class TaxBreakdownNotFoundException extends Exception {
    public TaxBreakdownNotFoundException() {
        super("Tax Breakdown Not Found");
    }
}