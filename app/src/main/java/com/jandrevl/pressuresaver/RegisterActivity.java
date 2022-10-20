package com.jandrevl.pressuresaver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class RegisterActivity extends AppCompatActivity {

    EditText systolicEditText;
    EditText diastolicEditText;
    EditText pulseEditText;
    EditText dateEditText;
    EditText timeEditText;
    Button save;
    LocalDate date = LocalDate.now();
    LocalTime time = LocalTime.now();
    String dateString;
    String timeString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dateEditText = findViewById(R.id.dateEditText);
        timeEditText = findViewById(R.id.timeEditText);
        dateString = date.toString();
        timeString = time.format(DateTimeFormatter.ofPattern("HH:mm"));

        dateEditText.setText(dateString);
        timeEditText.setText(timeString);

    }

    public void saveMeasurement(View view) {


        finish();
    }
}