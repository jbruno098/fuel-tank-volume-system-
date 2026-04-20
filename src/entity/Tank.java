package entity;

import entity.enums.FuelType;

public class Tank {

    private Double capacity;
    private FuelType fuelType;

    public Tank() {}

    public Tank(Double capacity, FuelType fuelType) {
        this.capacity = capacity;
        this.fuelType = fuelType;
    }

    public Double getCapacity() {
        return capacity;
    }

    public FuelType getFuelType() {
        return fuelType;
    }
}
