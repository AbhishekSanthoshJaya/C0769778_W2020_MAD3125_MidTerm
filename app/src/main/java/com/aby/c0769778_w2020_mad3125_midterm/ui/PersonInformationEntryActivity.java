package com.aby.c0769778_w2020_mad3125_midterm.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.aby.c0769778_w2020_mad3125_midterm.R;
import com.aby.c0769778_w2020_mad3125_midterm.model.CRACustomer;
import com.aby.c0769778_w2020_mad3125_midterm.util.HelperMethods;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Calendar;

public class PersonInformationEntryActivity extends AppCompatActivity {

    private ImageView imgApprove;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    private TextInputEditText edtSINText;
    private TextInputLayout edtSIN;
    private TextInputLayout edtFirstName;
    private TextInputEditText edtFirstNameText;
    private TextInputLayout edtLastName;
    private TextInputEditText edtLastNameText;
    private TextInputEditText edtDateText;
    private TextInputLayout edtDate;
    private TextInputLayout edtFilingDate;
    private TextInputEditText edtFilingDateText;
    private TextInputLayout edtGrossIncome;
    private TextInputEditText edtGrossIncomeText;
    private TextInputLayout edtRRSP;
    private TextInputEditText edtRRSPText;
    private RadioButton rdBtnMale;
    private RadioButton rdBtnFemale;
    private RadioButton rdBtnOther;
    private TextView txtAgeWarning;

    private Button btnSubmit;
    private Button btnClear;
    private Button btnOK;

    String sinNumber;
    Long sinNumberNums;

    @Override
    protected void onStart()
    {
        super.onStart();
        clearFields();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //------- INIT, SETTING FIELDS, BASIC METHODS -------
        initialization();
        valueSetter();
        addingDatePicker();
        filingDateWarning();
        //sinValidations();

        //------- CODE TO PLAY CUSTOM AUDIO ON SCREEN LOAD -------
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.formfilloice);
        mp.start();

        //------- FORM BUTTON METHODS -------
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fieldChecker();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            clearFields();
            }
        });

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnClear.setVisibility(View.VISIBLE);
                btnSubmit.setVisibility(View.VISIBLE);
                txtAgeWarning.setVisibility(View.INVISIBLE);
                edtDateText.getText().clear();
                btnOK.setVisibility(View.INVISIBLE);
                edtDate.setError(null);
            }
        });
    }

    private void initialization()
    {
        imgApprove = findViewById(R.id.imgApprove);
        edtDateText = findViewById(R.id.edtDateText);
        edtDate = findViewById(R.id.edtDate);
        edtFilingDateText = findViewById(R.id.edtFilingDateText);
        edtFilingDate = findViewById(R.id.edtFilingDate);
        edtSIN = findViewById(R.id.edtSIN);
        edtSINText = findViewById(R.id.edtSINText);
        btnClear = findViewById(R.id.btnClear);
        btnSubmit = findViewById(R.id.btnSubmit);
        edtFirstName = findViewById(R.id.edtFirstName);
        edtFirstNameText = findViewById(R.id.edtFirstNameText);
        edtLastName = findViewById(R.id.edtLastName);
        edtLastNameText = findViewById(R.id.edtLastNameText);
        edtRRSP = findViewById(R.id.edtRRSP);
        edtRRSPText = findViewById(R.id.edtRRSPtext);
        edtGrossIncome = findViewById(R.id.edtGrossIncome);
        edtGrossIncomeText = findViewById(R.id.edtGrossIncomeText);
        rdBtnFemale = findViewById(R.id.rdBtnFemale);
        rdBtnMale = findViewById(R.id.rdBtnMale);
        rdBtnOther = findViewById(R.id.rdBtnOther);
        txtAgeWarning = findViewById(R.id.txtAgeWarning);
        btnOK = findViewById(R.id.btnOK);
    }

    private void valueSetter()
    {
        imgApprove.setImageResource(R.drawable.approve_icon);

        LocalDate date = LocalDate.now();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("dd-MMM-yyyy");
        edtFilingDateText.setText(date.toString(fmt));

        txtAgeWarning.setVisibility(View.INVISIBLE);
        btnOK.setVisibility(View.INVISIBLE);
    }

    public void fieldChecker()
    {
        boolean someFlag = false;
        if(edtSINText.getText().toString().isEmpty())
        {
            edtSIN.setError("Please enter your SIN");
            someFlag = true;
            return;
        }
        if(edtFirstNameText.getText().toString().isEmpty()){
            edtFirstName.setError("Please enter your first name");
            someFlag = true;
            return;
        }
        if(edtLastNameText.getText().toString().isEmpty())
        {
            edtLastName.setError("Please enter your date of birth");
            someFlag = true;
            return;
        }
        if(edtDateText.getText().toString().isEmpty())
        {
            edtDate.setError("Please enter your date of birth");
            someFlag = true;
            return;
        }
        if(edtGrossIncomeText.getText().toString().isEmpty())
        {
            edtGrossIncome.setError("Please enter your date of birth");
            someFlag = true;
            return;
        }
        if(edtRRSPText.getText().toString().isEmpty())
        {
            edtRRSP.setError("Please enter your date of birth");
            someFlag = true;
            return;
        }

        if(!someFlag)
        {
            int anotherFlag = 0;
            if(calcAge(edtDateText.getText().toString()) < 18) {
                anotherFlag = 1;
                txtAgeWarning.setVisibility(View.VISIBLE);
                btnClear.setVisibility(View.INVISIBLE);
                btnSubmit.setVisibility(View.INVISIBLE);
                btnOK.setVisibility(View.VISIBLE);
                edtDate.setError("Enter a valid date of birth");
            }

            if(!sinValidations(edtSINText.getText().toString()))
            {
                anotherFlag = 1;
                edtSIN.setError("Enter a valid SIN number");
            }

            if(anotherFlag == 0)
            {
                CRACustomer craCustomer = new CRACustomer(edtSINText.getText().toString(),
                        edtFirstNameText.getText().toString(),
                        edtLastNameText.getText().toString(),
                        getGender(),
                        edtDateText.getText().toString(),
                        Double.parseDouble(edtGrossIncomeText.getText().toString()),
                        Double.parseDouble(edtRRSPText.getText().toString()));
                Intent mIntent = new Intent(PersonInformationEntryActivity.this, TaxDataDetailsActivity.class);
                mIntent.putExtra("CRACustomer", craCustomer);
                startActivity(mIntent);
            }
        }
    }

    public boolean sinValidations(String s)
    {
        int someFlag = 0;
        if(s.length() == 9)
        {
            someFlag = 1;
            return true;
        }
//        if(edtSINText .getText().toString().matches("^(\\d{3}-\\d{3}-\\d{3})|(\\d{9})$"))
//        {
//            someFlag = 1;
//            return true;
//        }
        if(someFlag == 0)
        {
            return false;
        }
        return true;
    }

    private void filingDateWarning()
    {
        edtFilingDateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialAlertDialogBuilder(PersonInformationEntryActivity.this)
                        .setTitle("Invalid Action")
                        .setMessage("This field cannot be changed")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
            }
        });
    }
    private void addingDatePicker()
    {
        edtDateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        PersonInformationEntryActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {
                String date;
                month = month + 1;
                String monthName = getMonthName(month);
                date = day + "-" + monthName + "-" + year;
                edtDateText.setText(date);
            }
        };
    }

    public static String getMonthName(int monthNumber){
        String[] monthNames = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"};
        return monthNames[monthNumber-1];
    }

    private int calcAge(String s) {
        int age = 0;
        if(!edtDateText.getText().toString().isEmpty())
        {
            s = edtDateText.getText().toString();
            age = LocalDate.now().getYear() - HelperMethods.getInstance().stringToDate(s).getYear();
            return age;
        }
        Toast.makeText(PersonInformationEntryActivity.this, age, Toast.LENGTH_SHORT).show();
        return age;
    }

    public String getGender()
    {
        if (rdBtnMale.isChecked()){
            return "Male";
        }
        else if (rdBtnFemale.isChecked()) {
            return "Female";
        }
        else if(rdBtnOther.isChecked())
        {
            return "Other";
        }
        return null;
    }

    public void clearFields()
    {
        edtSINText.getText().clear();
        edtFirstNameText.getText().clear();
        edtLastNameText.getText().clear();
        edtDateText.getText().clear();
        edtGrossIncomeText.getText().clear();
        edtRRSPText.getText().clear();
        edtSIN.setError(null);
        edtDate.setError(null);

        rdBtnOther.setChecked(false);
        rdBtnMale.setChecked(false);
        rdBtnFemale.setChecked(false);
    }
}
