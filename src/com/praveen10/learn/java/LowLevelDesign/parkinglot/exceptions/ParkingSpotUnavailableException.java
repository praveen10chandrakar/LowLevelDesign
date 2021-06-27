package com.praveen10.learn.java.LowLevelDesign.parkinglot.exceptions;

public class ParkingSpotUnavailableException extends RuntimeException {
    public ParkingSpotUnavailableException(String message){
        super(message);
    }
}
