package entity;

import entity.enums.FuelType;

public class Tank {

    private Long id;
    private Double capacity;
    private FuelType fuelType;

    // HAS
    private MeasurementTable table;

    public Tank() {}

    public Tank(Long id, Double capacity, FuelType fuelType,MeasurementTable table) {
        this.id = id;
        this.capacity = capacity;
        this.fuelType = fuelType;
        this.table = table;
    }

    public Long getId() {
        return id;
    }

    public Double getCapacity() {
        return capacity;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public MeasurementTable getTable() {
        return table;
    }
}
