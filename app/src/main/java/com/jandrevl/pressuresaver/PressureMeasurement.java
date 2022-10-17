package com.jandrevl.pressuresaver;

import java.io.Serializable;
import java.time.LocalDateTime;

public class PressureMeasurement implements Serializable {

    private LocalDateTime date;
    private double systolic;
    private double diastolic;
    private int pulse;

    public PressureMeasurement(double systolic, double diastolic, int pulse) {
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.pulse = pulse;
        this.date = LocalDateTime.now();
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getSystolic() {
        return systolic;
    }

    public void setSystolic(double systolic) {
        this.systolic = systolic;
    }

    public double getDiastolic() {
        return diastolic;
    }

    public void setDiastolic(double diastolic) {
        this.diastolic = diastolic;
    }

    public int getPulse() {
        return pulse;
    }

    public void setPulse(int pulse) {
        this.pulse = pulse;
    }
}
