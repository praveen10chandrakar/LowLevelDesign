package com.praveen10.learn.java.LowLevelDesign.parkinglot;

import java.util.Date;
import java.util.UUID;

public class ParkingTicket {
    private UUID id;
    private ParkingSpot parkingSpot;
    private Date issueTime;


    public ParkingTicket(ParkingSpot parkingSpot, Date issueTime) {
        this.id = UUID.randomUUID();
        this.parkingSpot = parkingSpot;
        this.issueTime = issueTime;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public Date getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(Date issueTime) {
        this.issueTime = issueTime;
    }

    @Override
    public String toString() {
        return "ParkingTicket{" +
                "id=" + id +
                ", parkingSpot=" + parkingSpot +
                ", issueTime=" + issueTime +
                '}';
    }
}
