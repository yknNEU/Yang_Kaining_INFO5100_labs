package model;

public class VitalSigns {

    public String date;
    public double bloodPressure;
    public double temperature;
    public int pulse;

    public VitalSigns(String date, double bloodPressure, double temperature, int pulse) {
        this.date = date;
        this.bloodPressure = bloodPressure;
        this.temperature = temperature;
        this.pulse = pulse;
    }

    public VitalSigns() {
        this.date = "";
        this.bloodPressure = 0;
        this.temperature = 0;
        this.pulse = 0;
    }

    @Override
    public String toString() {
        return this.date;
    }
}
