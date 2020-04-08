package com.aby.c0769778_w2020_mad3125_midterm.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.aby.c0769778_w2020_mad3125_midterm.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.joda.time.PeriodType;
import org.joda.time.Years;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Calendar;

public class PersonInformationEntryActivity extends AppCompatActivity {

    private ImageView imgApprove;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private TextInputEditText edtDateText;
    private TextInputLayout edtDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //------- INIT AND SETTING FIELDS -------
        initialization();
        valueSetter();
        addingDatePicker();

        //------- CODE TO PLAY CUSTOM AUDIO ON SCREEN LOAD -------
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.formfilloice);
        mp.start();
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

    private void initialization()
    {
        imgApprove = findViewById(R.id.imgApprove);
        edtDateText = findViewById(R.id.edtDateText);
        edtDate = findViewById(R.id.edtDate);
    }

    private void valueSetter()
    {
        imgApprove.setImageResource(R.drawable.approve_icon);
    }

    public static String getMonthName(int monthNumber){
        String[] monthNames = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"};
        return monthNames[monthNumber-1];
    }

    public int calcAge(
            org.joda.time.LocalDate birthDate,
            org.joda.time.LocalDate currentDate) {
        Years age = Years.yearsBetween(birthDate, currentDate);
        return age.getYears();
    }
}
