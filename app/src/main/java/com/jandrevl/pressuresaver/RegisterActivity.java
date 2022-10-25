package com.jandrevl.pressuresaver;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
    SQLiteDatabase myDataBase;




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

        myDataBase = openOrCreateDatabase("pressureSaverDataBase", MODE_PRIVATE, null);


    }

    public void saveMeasurement(View view) {

        try {
            systolic = Integer.parseInt(systolicEditText.getText().toString());
        } catch (Exception e) {
            systolicEditText.setError("Must be a positive Integer");
            return;
        }
        if(systolic < 40 || systolic > 300) {
            systolicEditText.setError("Please input a valid value");
            return;
        }

        try {
            diastolic = Integer.parseInt(diastolicEditText.getText().toString());
        } catch (Exception e) {
            diastolicEditText.setError("Must be a positive Integer");
            return;
        }
        if(diastolic < 40 || diastolic > 300) {
            diastolicEditText.setError("Please input a valid value");
            return;
        }

        try {
            pulse = Integer.parseInt(pulseEditText.getText().toString());
        } catch (Exception e) {
            pulseEditText.setError("Must be a positive Integer");
            return;
        }
        if(pulse < 10 || pulse > 500) {
            pulseEditText.setError("Please input a valid value");
            return;
        }

        dateTime = dateString + " at " + timeString;

        String SQLStatement = String.format("INSERT INTO measurements VALUES(%s, %s, %s, '%s');", systolic, diastolic, pulse, dateTime);
        Log.i("SQL Statement is", SQLStatement);
        myDataBase.execSQL(SQLStatement);
        Toast.makeText(this, "Measurement registered successfully", Toast.LENGTH_SHORT).show();
        finish();
    }
}