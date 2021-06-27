package com.praveen10.learn.java.LowLevelDesign.parkinglot;

import java.util.Objects;

public abstract class ParkingSpot {

    private Integer id;
    private Boolean reserved;
    private String type;
    private Double hourlyCharge;

    public ParkingSpot(Integer id, String type, Double hourlyCharge) {
        this.id = id;
        this.reserved = false;
        this.type = type;
        this.hourlyCharge = hourlyCharge;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public Boolean getReserved() {
        return reserved;
    }

    public void setReserved(Boolean reserved) {
        this.reserved = reserved;
    }

    public Double getHourlyCharge() {
        return hourlyCharge;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "id=" + id +
                ", reserved=" + reserved +
                ", type='" + type + '\'' +
                ", hourlyCharge=" + hourlyCharge +
                '}';
    }
}
