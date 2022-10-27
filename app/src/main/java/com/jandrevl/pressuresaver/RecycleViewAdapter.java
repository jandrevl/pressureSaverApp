package com.jandrevl.pressuresaver;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
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
        if(measurements.get(position).getSystolic() < 120) {
            holder.systolic.setBackgroundColor(Color.GREEN);
        } else if(measurements.get(position).getSystolic() >=120 &&
                measurements.get(position).getSystolic() <= 129) {
            holder.systolic.setBackgroundColor(Color.YELLOW);
        } else if(measurements.get(position).getSystolic() >= 130 &&
                measurements.get(position).getSystolic() <= 139) {
            holder.systolic.setBackgroundColor(Color.rgb(255, 193,7));
        } else if(measurements.get(position).getSystolic() >= 140 &&
                measurements.get(position).getSystolic() < 181) {
            holder.systolic.setBackgroundColor(Color.rgb(255, 87,34));
            holder.systolic.setTextColor(ColorStateList.valueOf(Color.WHITE));
        } else {
            holder.systolic.setBackgroundColor(Color.rgb(168, 13,13));
            holder.systolic.setTextColor(ColorStateList.valueOf(Color.WHITE));
        }

        holder.diastolic.setText(String.valueOf(measurements.get(position).getDiastolic()));
        if(measurements.get(position).getDiastolic() < 80) {
            holder.diastolic.setBackgroundColor(Color.GREEN);
        }  else if(measurements.get(position).getDiastolic() >= 80 &&
                measurements.get(position).getDiastolic() <= 89) {
            holder.diastolic.setBackgroundColor(Color.rgb(255, 193,7));
        } else if(measurements.get(position).getDiastolic() >= 90 &&
                measurements.get(position).getDiastolic() < 120) {
            holder.diastolic.setBackgroundColor(Color.rgb(255, 87,34));
            holder.diastolic.setTextColor(ColorStateList.valueOf(Color.WHITE));
        } else {
            holder.diastolic.setBackgroundColor(Color.rgb(168, 13,13));
            holder.diastolic.setTextColor(ColorStateList.valueOf(Color.WHITE));
        }

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
