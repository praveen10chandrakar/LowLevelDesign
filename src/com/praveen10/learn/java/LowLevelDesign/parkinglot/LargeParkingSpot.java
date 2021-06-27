package com.praveen10.learn.java.LowLevelDesign.parkinglot;

public class LargeParkingSpot extends ParkingSpot{

    private static final String type = "LARGE";
    private static final Double hourlyCharge = 7.1;

    public LargeParkingSpot(Integer id){
        super(id,  type, hourlyCharge);
    }
}
