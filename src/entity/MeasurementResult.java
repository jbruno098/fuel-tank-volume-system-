package entity;

import java.time.LocalDateTime;

public class MeasurementResult {

    private Tank tank;
    private Integer cm;
    private Integer liters;
    private LocalDateTime moment;

    public MeasurementResult(Tank tank, Integer cm, Integer liters) {
        this.tank = tank;
        this.cm = cm;
        this.liters = liters;
        this.moment = LocalDateTime.now();
    }

    public Tank getTank() {
        return tank;
    }

    public Integer getCm() {
        return cm;
    }

    public Integer getLiters() {
        return liters;
    }

    @Override
    public String toString() {
        return "Tanque: " + tank.getFuelType() +
                "\nCentímetros: " + cm +
                "\nLitragem: " + liters +
                "\nData/Hora: " + moment;
    }
}
