package com.aby.c0769778_w2020_mad3125_midterm.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import com.aby.c0769778_w2020_mad3125_midterm.R;
import com.aby.c0769778_w2020_mad3125_midterm.model.CRACustomer;
import com.aby.c0769778_w2020_mad3125_midterm.util.HelperMethods;
import com.aby.c0769778_w2020_mad3125_midterm.util.TaxCalculator;

import org.joda.time.LocalDate;
import org.joda.time.Years;

public class TaxDataDetailsActivity extends AppCompatActivity {
    TextView txtRRSP, txtSin, txtFullName, txtBirthDate, txtGender, txtAge, txtGrossIncome, txtFederalTax, txtProvincialTax, txtCPP, txtEI, txtCarry, txtTotalTaxIncome, txtTotalTax;
    @SuppressLint("SetTextI18n")
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
        txtSin.setText(craCustomer.getSIN());
        txtGrossIncome.setText("$ " + HelperMethods.getInstance().doubleFormatter(craCustomer.getGrossIncome()));
        txtBirthDate.setText(craCustomer.getBirthDate());
        txtGender.setText(craCustomer.getGender());
        txtAge.setText(String.valueOf(getAge()));
        TaxCalculator taxCalculator = new TaxCalculator(craCustomer.getGrossIncome(), craCustomer.getRrspContributed());
        String provincialTax = HelperMethods.getInstance().doubleFormatter(taxCalculator.calcTaxProvince(craCustomer.getGrossIncome()));
        String federalTax = HelperMethods.getInstance().doubleFormatter(taxCalculator.calcTaxFederal(craCustomer.getGrossIncome()));
        String CPP = HelperMethods.getInstance().doubleFormatter(taxCalculator.calcCPP(craCustomer.getGrossIncome()));
        String EI = HelperMethods.getInstance().doubleFormatter(taxCalculator.calcEI(craCustomer.getGrossIncome()));
        double totalTax = Double.parseDouble(provincialTax) + Double.parseDouble(federalTax);
        txtProvincialTax.setText("$ " + provincialTax);
        txtFederalTax.setText("$ " +federalTax);
        txtCPP.setText("$ " +CPP);
        txtEI.setText("$ " +EI);
        txtTotalTax.setText("$ " +HelperMethods.getInstance().doubleFormatter(totalTax));
        txtRRSP.setText("$ " +HelperMethods.getInstance().doubleFormatter(craCustomer.getRrspContributed()));

         if(craCustomer.getRrspContributed() == 0)
         {
             String RRSP = HelperMethods.getInstance().doubleFormatter(craCustomer.getGrossIncome() * 0.18d);
             double totalTaxableIncome = craCustomer.getGrossIncome() - (Double.parseDouble(EI) - Double.parseDouble(CPP) + Double.parseDouble(RRSP));
             txtTotalTaxIncome.setText("$ " +HelperMethods.getInstance().doubleFormatter(totalTaxableIncome));
         }
         else
         {
             String RRSP = HelperMethods.getInstance().doubleFormatter(craCustomer.getRrspContributed());
             double totalTaxableIncome = craCustomer.getGrossIncome() - (Double.parseDouble(EI) - Double.parseDouble(CPP) + Double.parseDouble(RRSP));
             txtTotalTaxIncome.setText("$ " +HelperMethods.getInstance().doubleFormatter(totalTaxableIncome));
         }

        double maxRRSP =  0.18d * craCustomer.getGrossIncome();
        if(craCustomer.getRrspContributed() > maxRRSP)
        {
            Double finalCarry = craCustomer.getRrspContributed() - maxRRSP;
            txtCarry.setText("$ " +"-"+HelperMethods.getInstance().doubleFormatter(finalCarry));
            txtCarry.setTextColor(getResources().getColor(R.color.colorRed));
            txtCarry.setTypeface(null,Typeface.BOLD);
        }
        else
        {
            Double finalCarry =  maxRRSP - craCustomer.getRrspContributed();
            txtCarry.setText("$ " +HelperMethods.getInstance().doubleFormatter(finalCarry));
        }
    }

    public int getAge()
    {
//        LocalDate birthdate = HelperMethods.getInstance().stringToDate(txtBirthDate.getText().toString());
//        LocalDate now = new LocalDate();
                int age = 0;
           String bDate = txtBirthDate.getText().toString();
           age = LocalDate.now().getYear() - HelperMethods.getInstance().stringToDate(bDate).getYear();
//        return Years.yearsBetween(birthdate, now);
        return age;
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
        txtEI = findViewById(R.id.txtEI);
        txtTotalTaxIncome = findViewById(R.id.txtTotalTaxIncome);
        txtTotalTax = findViewById(R.id.txtTaxPayed);
    }
}

