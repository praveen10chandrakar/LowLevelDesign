package com.praveen10.learn.java.LowLevelDesign.parkinglot;

import java.util.Date;

public interface TariffCalculator {
    double calculateTariff(int fromHrs, int toHrs, ParkingSpot parkingSpot);
}
