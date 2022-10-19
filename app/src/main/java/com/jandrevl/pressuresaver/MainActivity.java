package com.jandrevl.pressuresaver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase myDataBase = openOrCreateDatabase("pressureSaverDataBase", MODE_PRIVATE, null);
        myDataBase.execSQL("CREATE TABLE IF NOT EXISTS measurements(systolic INT, diastolic INT, pulse INT, date VARCHAR);");
    }

    public void registerMeasurement(View view) {
        Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(intent);
    }
}