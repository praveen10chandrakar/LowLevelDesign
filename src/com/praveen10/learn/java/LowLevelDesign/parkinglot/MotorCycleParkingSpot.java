package com.praveen10.learn.java.LowLevelDesign.parkinglot;

public class MotorCycleParkingSpot extends ParkingSpot{
    private static final String type = "MOTORCYCLE";
    private static final Double hourlyCharge = 2.8;

    public MotorCycleParkingSpot(Integer id){
        super(id,  type, hourlyCharge);
    }}
