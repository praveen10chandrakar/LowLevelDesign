package com.praveen10.learn.java.LowLevelDesign.parkinglot;

public class HandicappedParkingSpot extends ParkingSpot{

    private static final String type = "HANDICAPPED";
    private static final Double hourlyCharge = 2.2;

    public HandicappedParkingSpot(Integer id){
        super(id,  type, hourlyCharge);
    }

}
