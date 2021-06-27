package com.praveen10.learn.java.LowLevelDesign.parkinglot;

import com.praveen10.learn.java.LowLevelDesign.parkinglot.exceptions.ParkingSpotUnavailableException;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Terminal {

    private Integer id;

    private HashSet<ParkingSpot> availableParkingSpots;
    private HashSet<ParkingSpot> reservedParkingSpots;
    private PriorityQueue<ParkingSpot> parkingSpotsQueue;

    public Terminal(Integer id) {
        this.id = id;
        availableParkingSpots = new HashSet<>();
        reservedParkingSpots = new HashSet<>();
        parkingSpotsQueue = new PriorityQueue<ParkingSpot>(Comparator.comparingInt(ParkingSpot::getId));
    }

    public Integer getId() {
        return id;
    }

    public Boolean hasNextAvailableSpot(String type){
        for (ParkingSpot spot: availableParkingSpots){
            if (spot.getType().equals(type)){
                return true;
            }
        }
        return false;
    }

    public void addToAvailableParkingSpot(ParkingSpot parkingSpot){
        availableParkingSpots.add(parkingSpot);
        parkingSpotsQueue.add(parkingSpot);
    }

    public boolean removeParkingSpot(ParkingSpot parkingSpot){
        return availableParkingSpots.remove(parkingSpot);
    }

    public ParkingSpot getNextAvailableSpot(String type) throws ParkingSpotUnavailableException{
        if(!hasNextAvailableSpot(type)){
            System.out.println("No parking spots are available");
            throw new ParkingSpotUnavailableException("No parking spots are available");
        }

        PriorityQueue<ParkingSpot> priorityQueue = new PriorityQueue(parkingSpotsQueue);

        while (!priorityQueue.isEmpty() && !priorityQueue.peek().getType().equalsIgnoreCase(type)){
            priorityQueue.poll();
        }

        return priorityQueue.peek();
    }

    public ParkingSpot assignParkingSpot(String type) {

        ParkingSpot parkingSpot = getNextAvailableSpot(type);
        parkingSpot.setReserved(true);
        availableParkingSpots.remove(parkingSpot);
        reservedParkingSpots.add(parkingSpot);
        parkingSpotsQueue.remove(parkingSpot);

        return parkingSpot;
    }

    public boolean releaseParkingSpot(ParkingSpot parkingSpot){
        if(!reservedParkingSpots.contains(parkingSpot)){
            System.out.println("Parking Spot " + parkingSpot.getId() + " is already released");
            return false;
        }

        parkingSpot.setReserved(false);
        availableParkingSpots.add(parkingSpot);
        reservedParkingSpots.remove(parkingSpot);
        parkingSpotsQueue.add(parkingSpot);

        System.out.println("Releasing Parking Spot: " + parkingSpot.toString());
        return true;
    }

    public void printLayout(){
        for (ParkingSpot spot: parkingSpotsQueue){
            System.out.println(spot);
        }
    }
}
