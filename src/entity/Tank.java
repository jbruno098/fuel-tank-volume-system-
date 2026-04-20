package entity;

import entity.enums.FuelType;

public class Tank {

    private Long id;
    private Double capacity;
    private FuelType fuelType;

    public Tank() {}

    public Tank(Long id, Double capacity, FuelType fuelType) {
        this.id = id;
        this.capacity = capacity;
        this.fuelType = fuelType;
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
}
