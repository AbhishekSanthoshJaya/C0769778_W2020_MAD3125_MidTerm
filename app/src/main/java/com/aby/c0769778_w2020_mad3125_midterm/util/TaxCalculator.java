package com.aby.c0769778_w2020_mad3125_midterm.util;

public class TaxCalculator {

    private double grossIncome;
    private double rrspAmount;

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


    public double complexCalcTaxProvince(double TaxableIncome)
    {
        double taxRate = 0.0;
        double temp1 = 0.0;
        if (TaxableIncome > 10582.0d) {
             temp1 = TaxableIncome - 10582.0d;
            if (temp1 > 43906.0) {
                temp1 = temp1 - (43906.0 - 10582.0);
                taxRate = taxRate + ((43906.0 - 10582.0) * 0.0505);
                if (temp1 > 87813.0) {
                    taxRate = taxRate + ((87813 - 43906) * 0.0915);
                    temp1 = temp1 - (87813 - 43906);
                    if (temp1 > 150000.0d) {
                        taxRate = taxRate + ((150000 - 87813) * 0.1116);
                        temp1 = temp1 - (150000 - 87813);
                        if (temp1 > 220000.0d) {
                            taxRate = taxRate + ((220000 - 150000) * 0.1216);
                            temp1 = temp1 - (220000 - 150000);
                            if (temp1 > 220000.01d) {
                                taxRate = taxRate + (temp1 * 0.1316);
                            }
                        } else
                            {
                            taxRate = taxRate + (temp1 * 0.1316);
                        }
                    } else
                        {
                        taxRate = taxRate + (temp1 * 0.1216);
                    }
                } else
                    {
                    taxRate = taxRate + (temp1 * 0.116);
                }
            } else
                {
                taxRate = taxRate + (temp1 * 0.0915);
            }
        }
        else
        {
            taxRate = taxRate + (temp1 * 0.0505);
        }
        return temp1;
    }

    public double calcTaxProvince(double TaxableIncome)
    {
        if(TaxableIncome <= 10582.0d) {
            return 0.0d;
        }
        else if(TaxableIncome >= 10582.0d && TaxableIncome <=43906.0d)
        {
            return 0.0505d;
        }
        else if(TaxableIncome >= 43906.0d && TaxableIncome <= 87813.0d)
        {
            return 0.0915d;
        }
        else if (TaxableIncome >= 87813.0d && TaxableIncome <= 150000.0d) {
            return 0.1116d;
        }
        else if (TaxableIncome >= 150000.0d && TaxableIncome <= 220000.0d)
        {
            return 0.1216d;
        }
        else
        {
        return 0.1316d;
        }
    }

//    public double complexCalcTaxFederal(double TaxableIncome)
////    {
////        double taxRate = 0.0d, temp1;
////        if(TaxableIncome > 12069.0d)
////        {
////            temp1 = TaxableIncome - 12069.0d;
////            taxRate = 0.0d;
////            if()
////        }
////    }
    public double calcTaxFederal(double TaxableIncome)
    {
        if(TaxableIncome <=  12069.0d) {
            return 0.0d;
        }
        else if(TaxableIncome >= 12069.0d && TaxableIncome <= 47630.0d){
            return 0.15d;
        }
        else if(TaxableIncome >= 47630.01d && TaxableIncome <= 95259.0d){
            return 0.2050d;
        }
        else if(TaxableIncome >= 95259.01d && TaxableIncome <= 147667.0d){
            return 0.26d;
        }
        else if(TaxableIncome >= 147667.01d && TaxableIncome <= 210371.0d){
            return 0.29d;
        }
        else {
            return 0.33d;
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
