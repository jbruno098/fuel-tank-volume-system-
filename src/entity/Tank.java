package entity;

import entity.enums.FuelType;

public class Tank {

    private int id;
    private Integer capacity;
    private FuelType fuelType;

    // HAS
    private MeasurementTable table;

    public Tank() {}

    public Tank(int id, Integer capacity, FuelType fuelType,MeasurementTable table) {
        this.id = id;
        this.capacity = capacity;
        this.fuelType = fuelType;
        this.table = table;
    }

    public int getId() {
        return id;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public MeasurementTable getTable() {
        return table;
    }
}
