package com.jandrevl.pressuresaver;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
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
            systolicEditText.setError("Must be a number between 100 and 250");
            return;
        }
        if(systolic < 100 || systolic > 250) {
            systolicEditText.setError("Must be an Integer between 100 and 250");
            return;
        }

        diastolic = Integer.parseInt(diastolicEditText.getText().toString());

        pulse = Integer.parseInt(pulseEditText.getText().toString());

        dateTime = dateString + " at " + timeString;
        String SQLStatement = String.format("INSERT INTO measurements VALUES(%s, %s, %s, '%s');", systolic, diastolic, pulse, dateTime);
        Log.i("SQL Statement is", SQLStatement);
        myDataBase.execSQL(SQLStatement);


        finish();
    }
}