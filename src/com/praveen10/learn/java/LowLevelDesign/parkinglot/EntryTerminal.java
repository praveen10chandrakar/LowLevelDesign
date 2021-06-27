package com.praveen10.learn.java.LowLevelDesign.parkinglot;

import java.util.Date;

public class EntryTerminal {

    private Terminal terminal;

    public EntryTerminal(Terminal terminal){
        this.terminal = terminal;
    }

    public ParkingTicket getTicket(String parkingSpotType){

        ParkingSpot parkingSpot = terminal.assignParkingSpot(parkingSpotType);
        System.out.println("Assigned Parking spot: " + parkingSpot.toString());

        ParkingTicket ticket = new ParkingTicket(parkingSpot, new Date());
        return ticket;
    }

}
