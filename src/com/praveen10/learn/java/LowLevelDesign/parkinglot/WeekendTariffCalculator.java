package com.praveen10.learn.java.LowLevelDesign.parkinglot;

import java.util.Date;

public class WeekendTariffCalculator implements TariffCalculator{

    private static final Double tariff = 1.03;

    @Override
    public double calculateTariff(int fromHrs, int toHrs, ParkingSpot parkingSpot) {

        int duration = toHrs - fromHrs;
        Double hourlyCharge = parkingSpot.getHourlyCharge();

        return duration * hourlyCharge * tariff;
    }
}
