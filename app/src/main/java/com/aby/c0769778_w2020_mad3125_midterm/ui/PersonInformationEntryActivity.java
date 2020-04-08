package com.aby.c0769778_w2020_mad3125_midterm.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;

import com.aby.c0769778_w2020_mad3125_midterm.R;

public class PersonInformationEntryActivity extends AppCompatActivity {

    private ImageView imgApprove;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //------- INIT AND SETTING FIELDS -------
        initialization();
        valueSetter();

        //------- CODE TO PLAY CUSTOM AUDIO ON SCREEN LOAD -------
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.formfilloice);
        mp.start();

    }

    private void initialization()
    {
        imgApprove = findViewById(R.id.imgApprove);
    }

    private void valueSetter()
    {
        imgApprove.setImageResource(R.drawable.approve_icon);
    }
}
