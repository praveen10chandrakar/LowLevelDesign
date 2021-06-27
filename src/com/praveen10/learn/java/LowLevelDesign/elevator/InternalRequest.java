package com.praveen10.learn.java.LowLevelDesign.elevator;

public class InternalRequest {
    private int destinationFloor;

    public InternalRequest(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    @Override
    public String toString() {
        return "The destinationFloor is - " + destinationFloor;
    }
}
