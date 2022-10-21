package com.jandrevl.pressuresaver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RegisterActivity extends AppCompatActivity {

    EditText systolicEditText;
    EditText diastolicEditText;
    EditText pulseEditText;
    EditText dateEditText;
    EditText timeEditText;
    Button save;
    LocalDate localDateNow = LocalDate.now();
    LocalTime localTimeNow = LocalTime.now();
    String dateString;
    String timeString;
    int systolic;
    int diastolic;
    int pulse;
    String dateTime;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dateEditText = findViewById(R.id.dateEditText);
        timeEditText = findViewById(R.id.timeEditText);
        dateString = localDateNow.toString();
        timeString = localTimeNow.format(DateTimeFormatter.ofPattern("HH:mm"));

        dateEditText.setText(dateString);
        timeEditText.setText(timeString);

        systolicEditText = findViewById(R.id.systolicEditText);
        diastolicEditText = findViewById(R.id.diastolicEditText);
        pulseEditText = findViewById(R.id.pulseEditText);

    }

    public void saveMeasurement(View view) {

        systolic = Integer.parseInt(systolicEditText.getText().toString());
        diastolic = Integer.parseInt(diastolicEditText.getText().toString());
        pulse = Integer.parseInt(pulseEditText.getText().toString());



        finish();
    }
}