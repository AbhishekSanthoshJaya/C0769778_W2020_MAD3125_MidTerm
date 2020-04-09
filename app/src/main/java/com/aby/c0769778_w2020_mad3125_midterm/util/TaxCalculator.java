package com.aby.c0769778_w2020_mad3125_midterm.util;

public class TaxCalculator {

    double grossIncome;
    double rrspAmount;

    public TaxCalculator(Double grossIncome, double rrspAmount) {
        this.grossIncome = grossIncome;
        this.rrspAmount = rrspAmount;
    }

    public Double getGrossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(Double grossIncome) {
        this.grossIncome = grossIncome;
    }

    public double getRrspAmount() {
        return rrspAmount;
    }

    public void setRrspAmount(float rrspAmount) {
        this.rrspAmount = rrspAmount;
    }

    public double calcTaxProvince(Double grossIncome)
    {
        if(grossIncome <= 10582) {
            return grossIncome*0.0;
        }
        else if(grossIncome >= 10582 && grossIncome <=43906)
        {
            return grossIncome*5.05;
        }
        else if(grossIncome >= 43906 && grossIncome >= 87813)
        {
            return grossIncome*9.15;
        }
        else if (grossIncome >= 87813.0 && grossIncome <= 150000) {
            return grossIncome*11.16;
        }
        else if (grossIncome >= 150000.0 && grossIncome <= 220000)
        {
            return grossIncome*12.16;
        }
        else {
            return grossIncome*13.16;
        }
    }

    public double calcTaxFederal(double grossIncome)
    {
        if(grossIncome <=  12069.0) {
            return grossIncome*0.0;
        }
        else if(grossIncome > 12069 && grossIncome <= 47630){
            return grossIncome*15;
        }
        else if(grossIncome > 47630 && grossIncome <= 95259){
            return grossIncome*20.50;
        }
        else if(grossIncome > 95259 && grossIncome <= 147667){
            return grossIncome*26;
        }
        else if(grossIncome > 147667 && grossIncome <= 210371){
            return grossIncome*29;
        }
        else {
            return grossIncome*33;
        }
    }

    public double calcCPP(double grossIncome)
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
