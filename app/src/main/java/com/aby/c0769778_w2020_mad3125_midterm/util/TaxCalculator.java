package com.aby.c0769778_w2020_mad3125_midterm.util;

public class TaxCalculator {

    Float grossIncome;
    Float rrspAmount;

    public TaxCalculator(Float grossIncome, Float rrspAmount) {
        this.grossIncome = grossIncome;
        this.rrspAmount = rrspAmount;
    }

    public Float getGrossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(Float grossIncome) {
        this.grossIncome = grossIncome;
    }

    public Float getRrspAmount() {
        return rrspAmount;
    }

    public void setRrspAmount(Float rrspAmount) {
        this.rrspAmount = rrspAmount;
    }

    public double calcTaxRateProvince(Float grossIncome)
    {
        if(grossIncome <= 10582) {
            return 0.0;
        }
        else if(grossIncome >= 10582 && grossIncome <=43906)
        {
            return 5.05;
        }
        else if(grossIncome >= 43906 && grossIncome >= 87813)
        {
            return 9.15;
        }
        else if (grossIncome >= 87813.0 && grossIncome <= 150000) {
            return 11.16;
        }
        else if (grossIncome >= 150000.0 && grossIncome <= 220000)
        {
            return 12.16;
        }
        else {
            return 13.16;
        }
    }

    public double calcTaxRateFederal(Float grossIncome)
    {
        if(grossIncome <=  12069.0) {
            return 0.0;
        }
        else if(grossIncome > 12069 && grossIncome <= 47630){
            return 15;
        }
        else if(grossIncome > 47630 && grossIncome <= 95259){
            return 20.50;
        }
        else if(grossIncome > 95259 && grossIncome <= 147667){
            return 26;
        }
        else if(grossIncome > 147667 && grossIncome <= 210371){
            return 29;
        }
        else {
            return 33;
        }
    }
}
