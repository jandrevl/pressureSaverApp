package com.jandrevl.pressuresaver;

import java.time.LocalDateTime;

public class PressureMeasurement {

    private LocalDateTime date;
    private double systolic;
    private double dyastolic;
    private int pulse;

    public PressureMeasurement(double systolic, double dyastolic, int pulse) {
        this.systolic = systolic;
        this.dyastolic = dyastolic;
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

    public double getDyastolic() {
        return dyastolic;
    }

    public void setDyastolic(double dyastolic) {
        this.dyastolic = dyastolic;
    }

    public int getPulse() {
        return pulse;
    }

    public void setPulse(int pulse) {
        this.pulse = pulse;
    }
}
