package com.aby.c0769778_w2020_mad3125_midterm.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.aby.c0769778_w2020_mad3125_midterm.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.joda.time.LocalDate;
import org.joda.time.PeriodType;
import org.joda.time.Years;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.time.Month;
import java.time.Period;
import java.util.Calendar;

public class PersonInformationEntryActivity extends AppCompatActivity {

    private ImageView imgApprove;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private TextInputEditText edtDateText;
    private TextInputLayout edtDate;
    private TextInputLayout edtFilingDate;
    private TextInputEditText edtFilingDateText;
    private TextInputEditText edtSINText;
    private TextInputLayout edtSIN;

    String sinNumber;
    Long sinNumberNums;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //------- INIT, SETTING FIELDS, BASIC METHODS -------
        initialization();
        valueSetter();
        addingDatePicker();
        filingDateWarning();
        sinValidations();
        //------- CODE TO PLAY CUSTOM AUDIO ON SCREEN LOAD -------
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.formfilloice);
        mp.start();
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
    }

    private void valueSetter()
    {
        imgApprove.setImageResource(R.drawable.approve_icon);

        LocalDate date = LocalDate.now();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("d - MMM - yyyy");
        edtFilingDateText.setText(date.toString(fmt));
    }

    private Integer getCount(long n)
    {
        int count = 0;
        while (n != 0) {
            n = n / 10;
            ++count;
        }
        return count;
    }

    private void sinValidations() {
            edtSINText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    sinNumber = edtSINText.getText().toString();
                    if (sinNumber != null) {
                        sinNumberNums = Long.parseLong(sinNumber);
                        if (getCount(sinNumberNums) != 9) {
                            edtSINText.setError("Please enter a 9 digit number");
                        }
                    }
                }
            });
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
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                String date;
                month = month + 1;
                String monthName = getMonthName(month);
                if(day>9)
                    {
                        date = day + " - " + monthName + " - " + year;
                    }
                else
                    {
                        date = "0"+day + " - " + monthName + " - " + year;
                    }
                edtDateText.setText(date);
            }
        };
    }

    public static String getMonthName(int monthNumber){
        String[] monthNames = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"};
        return monthNames[monthNumber-1];
    }

    public int calcAge(org.joda.time.LocalDate birthDate, org.joda.time.LocalDate currentDate) {
        Years age = Years.yearsBetween(birthDate, currentDate);
        return age.getYears();
    }
}
