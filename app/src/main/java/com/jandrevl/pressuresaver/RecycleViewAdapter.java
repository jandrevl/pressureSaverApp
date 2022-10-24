package com.jandrevl.pressuresaver;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    List<PressureMeasurement> measurements;
    Context context;

    public RecycleViewAdapter(List<PressureMeasurement> measurements, Context context) {
        this.measurements = measurements;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pressure_measurement_line, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.systolic.setText(String.valueOf(measurements.get(position).getSystolic()));
        holder.diastolic.setText(String.valueOf(measurements.get(position).getDiastolic()));
        holder.pulse.setText(String.valueOf(measurements.get(position).getPulse()));
        holder.dateTime.setText(measurements.get(position).getDateTime());

    }

    @Override
    public int getItemCount() {
        return measurements.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView systolic;
        TextView diastolic;
        TextView pulse;
        TextView dateTime;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            systolic = itemView.findViewById(R.id.systolicLineTextView);
            diastolic = itemView.findViewById(R.id.diastolicLineTextView);
            pulse = itemView.findViewById(R.id.pulseLineTextView);
            dateTime = itemView.findViewById((R.id.dateLineTextView));
        }
    }
}
