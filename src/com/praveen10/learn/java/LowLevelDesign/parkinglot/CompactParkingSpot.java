package com.praveen10.learn.java.LowLevelDesign.parkinglot;

public class CompactParkingSpot extends ParkingSpot{

    private static final String type = "COMPACT";
    private static final Double hourlyCharge = 3.1;

    public CompactParkingSpot(Integer id){
        super(id,  type, hourlyCharge);
    }
}
