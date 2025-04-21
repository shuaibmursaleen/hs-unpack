package com.shuaib.hscodes.taxbreakdown.exceptions;

public class TaxBreakdownNotFoundException extends Exception {
    public TaxBreakdownNotFoundException() {
        super("Tax Breakdown Not Found");
    }
}