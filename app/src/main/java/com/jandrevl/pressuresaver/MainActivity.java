package com.jandrevl.pressuresaver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase myDataBase = openOrCreateDatabase("pressureSaverDataBase", MODE_PRIVATE, null);
        myDataBase.execSQL("CREATE TABLE IF NOT EXISTS measurements(systolic INT, diastolic INT, pulse INT, date VARCHAR);");
        Cursor resultSet = myDataBase.rawQuery("SELECT * FROM measurements", null);
        resultSet.moveToFirst();
        int systole = resultSet.getInt(0);
        int diastole = resultSet.getInt(1);
        String dateTime = resultSet.getString(3);
        Log.i("getting data from SQL", "Systole: " + systole + ", Diastole: " + diastole + ", Date and Time: " + dateTime);
    }

    public void registerMeasurement(View view) {
        Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(intent);
    }

    public void goToPreviousMeasurements(View view) {
        Intent intent = new Intent(getApplicationContext(), MeasurementsHistoryActivity.class);
        startActivity(intent);
    }
}