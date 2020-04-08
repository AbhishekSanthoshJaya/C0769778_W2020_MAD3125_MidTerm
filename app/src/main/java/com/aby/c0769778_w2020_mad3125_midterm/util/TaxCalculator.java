package com.aby.c0769778_w2020_mad3125_midterm.util;

public class TaxCalculator {

    Double grossIncome;
    Double rrspAmount;

    public TaxCalculator(Double grossIncome, Double rrspAmount) {
        this.grossIncome = grossIncome;
        this.rrspAmount = rrspAmount;
    }

    public Double getGrossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(Double grossIncome) {
        this.grossIncome = grossIncome;
    }

    public Double getRrspAmount() {
        return rrspAmount;
    }

    public void setRrspAmount(Double rrspAmount) {
        this.rrspAmount = rrspAmount;
    }

    public double calcTaxRateProvince(Double grossIncome)
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

    public double calcCPP()
    {
        double cpp;
        if(this.grossIncome >= 57400)
        {
            cpp = 57400*0.051;
        }
        else {
            cpp = grossIncome*0.051;
        }
        return cpp;
    }

    public boolean maxRRSP()
    {
        double rrsp = 0.0;
        if(rrsp >= this.grossIncome*0.18)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public double calcRRSP()
    {
        return this.rrspAmount * 0.18;
    }

    public double calcEI()
    {
        double ei;
        if(this.grossIncome >= 53100)
        {
            ei = 53100*0.0162;
        }
        else
        {
            ei = grossIncome*0.0162;
        }
        return ei;
    }
}
