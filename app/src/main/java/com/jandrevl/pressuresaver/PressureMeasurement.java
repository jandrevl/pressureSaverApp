package com.jandrevl.pressuresaver;

public class PressureMeasurement {
    private int diastolic;
    private int systolic;
    private int pulse;
    private String dateTime;

    public PressureMeasurement(int diastolic, int systolic, int pulse, String dateTime) {
        this.diastolic = diastolic;
        this.systolic = systolic;
        this.pulse = pulse;
        this.dateTime = dateTime;
    }

    public int getDiastolic() {
        return diastolic;
    }

    public void setDiastolic(int diastolic) {
        this.diastolic = diastolic;
    }

    public int getSystolic() {
        return systolic;
    }

    public void setSystolic(int systolic) {
        this.systolic = systolic;
    }

    public int getPulse() {
        return pulse;
    }

    public void setPulse(int pulse) {
        this.pulse = pulse;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "PressureMeasurement{" +
                "diastolic=" + diastolic +
                ", systolic=" + systolic +
                ", pulse=" + pulse +
                ", dateTime='" + dateTime + '\'' +
                '}';
    }
}
