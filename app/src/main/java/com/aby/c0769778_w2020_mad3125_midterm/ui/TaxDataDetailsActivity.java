package com.aby.c0769778_w2020_mad3125_midterm.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.aby.c0769778_w2020_mad3125_midterm.R;
import com.aby.c0769778_w2020_mad3125_midterm.model.CRACustomer;
import com.aby.c0769778_w2020_mad3125_midterm.util.HelperMethods;
import com.aby.c0769778_w2020_mad3125_midterm.util.TaxCalculator;

public class TaxDataDetailsActivity extends AppCompatActivity {
    TextView txtSin, txtFullName, txtBirthDate, txtGender, txtAge, txtGrossIncome, txtFederalTax, txtProvincialTax, txtCPP, txtEI, txtCarry, txtTotalTaxIncome, txtTotalTax;
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
        txtGrossIncome.setText(Double.toString(craCustomer.getGrossIncome()));
        txtBirthDate.setText(craCustomer.getBirthDate().toString());
        //txtGender.setText(craCustomer.getGender().toString());
        TaxCalculator txCalc = new TaxCalculator(craCustomer.getGrossIncome(), craCustomer.getRrspContributed());
    }

    public void initialization2()
    {
        txtFullName = findViewById(R.id.txtfullName);
        txtSin = findViewById(R.id.txtSinNumber);
        txtBirthDate = findViewById(R.id.txtBirthDate);
        txtGender = findViewById(R.id.txtGender);
       // txtAge = findViewById(R.id.txtAge);
        txtGrossIncome = findViewById(R.id.txtGrossIncome);
    }

}

