package com.jandrevl.pressuresaver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MeasurementsHistoryActivity extends AppCompatActivity {

    List<PressureMeasurement> measurements = new ArrayList<PressureMeasurement>();
    SQLiteDatabase myDataBase;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurements_history);
        myDataBase = openOrCreateDatabase("pressureSaverDataBase", MODE_PRIVATE, null);
        recyclerView = findViewById(R.id.measurementsRecyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new RecycleViewAdapter(measurements, this);
        recyclerView.setAdapter(mAdapter);

        fillMeasurementsList();
        for(PressureMeasurement measurement : measurements) {
            Log.i("List Item", measurement.toString());
        }
    }

    private void fillMeasurementsList() {
        Cursor resultSet = myDataBase.rawQuery("SELECT * FROM measurements", null);
        resultSet.moveToLast();
        while(!resultSet.isBeforeFirst()) {
            PressureMeasurement pressureMeasurement = new PressureMeasurement(
                    resultSet.getInt(0),
                    resultSet.getInt(1),
                    resultSet.getInt(2),
                    resultSet.getString(3)
            );
            measurements.add(pressureMeasurement);
            resultSet.moveToPrevious();
        }

    }
}