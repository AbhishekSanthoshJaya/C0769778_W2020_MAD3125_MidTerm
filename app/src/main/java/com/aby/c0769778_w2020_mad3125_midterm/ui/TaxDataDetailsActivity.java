package com.aby.c0769778_w2020_mad3125_midterm.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.Helper;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import com.aby.c0769778_w2020_mad3125_midterm.R;
import com.aby.c0769778_w2020_mad3125_midterm.model.CRACustomer;
import com.aby.c0769778_w2020_mad3125_midterm.util.HelperMethods;
import com.aby.c0769778_w2020_mad3125_midterm.util.TaxCalculator;

public class TaxDataDetailsActivity extends AppCompatActivity {
    TextView txtRRSP, txtSin, txtFullName, txtBirthDate, txtGender, txtAge, txtGrossIncome, txtFederalTax, txtProvincialTax, txtCPP, txtEI, txtCarry, txtTotalTaxIncome, txtTotalTax;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tax_data_details);
        initialization2();
        Intent intent = getIntent();
        CRACustomer craCustomer = intent.getParcelableExtra("CRACustomer");
        String firstName = craCustomer.getFirstName();
        String lastName = craCustomer.getLastName().toUpperCase();
        String fullName = lastName + ", " +firstName;
        txtFullName.setText(fullName);
        txtGrossIncome.setText(HelperMethods.getInstance().doubleFormatter(craCustomer.getGrossIncome()));
        //txtBirthDate.setText(craCustomer.getBirthDate().toString());
        //txtGender.setText(craCustomer.getGender().toString());
        TaxCalculator taxCalculator = new TaxCalculator(craCustomer.getGrossIncome(), craCustomer.getRrspContributed());
        String provincialTax = HelperMethods.getInstance().doubleFormatter(taxCalculator.calcTaxProvince(craCustomer.getGrossIncome()));
        String federalTax = HelperMethods.getInstance().doubleFormatter(taxCalculator.calcTaxFederal(craCustomer.getGrossIncome()));
        String CPP = HelperMethods.getInstance().doubleFormatter(taxCalculator.calcCPP(craCustomer.getGrossIncome()));
        txtProvincialTax.setText("province" + provincialTax);
        txtFederalTax.setText("fed" + federalTax);
        txtCPP.setText(CPP);
        txtRRSP.setText(HelperMethods.getInstance().doubleFormatter(craCustomer.getRrspContributed()));


        double maxRRSP =  0.18d * craCustomer.getGrossIncome();
        if(craCustomer.getRrspContributed() > maxRRSP)
        {
            Double finalCarry = craCustomer.getRrspContributed() - maxRRSP;
            txtCarry.setText(HelperMethods.getInstance().doubleFormatter(finalCarry));
            txtCarry.setTextColor(getResources().getColor(R.color.colorRed));
            txtBirthDate.setText(HelperMethods.getInstance().doubleFormatter(maxRRSP));
            txtCarry.setTypeface(null,Typeface.BOLD);
        }
        else
        {
            Double finalCarry =  maxRRSP - craCustomer.getRrspContributed();
            txtCarry.setText(HelperMethods.getInstance().doubleFormatter(finalCarry));
        }

    }

    public void initialization2()
    {
        txtFullName = findViewById(R.id.txtfullName);
        txtSin = findViewById(R.id.txtSinNumber);
        txtBirthDate = findViewById(R.id.txtBirthDate);
        txtGender = findViewById(R.id.txtGender);
        txtAge = findViewById(R.id.txtAge);
        txtGrossIncome = findViewById(R.id.txtGrossIncome);
        txtFederalTax = findViewById(R.id.txtFederalTax);
        txtProvincialTax = findViewById(R.id.txtProvincialTax);
        txtCPP = findViewById(R.id.txtCPP);
        txtCarry = findViewById(R.id.txtCarryForward);
        txtRRSP = findViewById(R.id.txtRRSP);
    }
}

