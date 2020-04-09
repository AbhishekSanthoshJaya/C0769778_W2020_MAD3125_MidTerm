package com.aby.c0769778_w2020_mad3125_midterm.util;

public class TaxCalculator {

    double grossIncome;
    double rrspAmount;

    public TaxCalculator(double grossIncome, double rrspAmount) {
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


//    public double complexCalcTaxProvince(double grossIncome)
//    {
//        double temp1, temp2, temp3, temp4;
//        if(grossIncome <= 10582)
//        {
//
//        }
//    }

    public double calcTaxProvince(double grossIncome)
    {
        if(grossIncome <= 10582) {
            return 0.0d;
        }
        else if(grossIncome >= 10582.0d && grossIncome <=43906.0d)
        {
            return 0.505d;
        }
        else if(grossIncome >= 43906.0d && grossIncome <= 87813.0d)
        {
            return 0.915d;
        }
        else if (grossIncome >= 87813.0 && grossIncome <= 150000.0d) {
            return 0.1116d;
        }
        else if (grossIncome >= 150000.0d && grossIncome <= 220000.0d)
        {
            return 0.1216d;
        }
        else
        {
        return 0.1316d;
        }
    }

    public double calcTaxFederal(double grossIncome)
    {
        if(grossIncome <=  12069.0d) {
            return 0.0;
        }
        else if(grossIncome >= 12069.0d && grossIncome <= 47630.0d){
            return 0.15;
        }
        else if(grossIncome >= 47630.0d && grossIncome <= 95259.0d){
            return 0.2050;
        }
        else if(grossIncome >= 95259.0d && grossIncome <= 147667.0d){
            return 0.26;
        }
        else if(grossIncome >= 147667.0d && grossIncome <= 210371.0d){
            return 0.29;
        }
        else {
            return 0.33;
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


    public double calcEI(double grossIncome)
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
