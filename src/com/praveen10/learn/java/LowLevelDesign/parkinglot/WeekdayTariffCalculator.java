package com.praveen10.learn.java.LowLevelDesign.parkinglot;

public class WeekdayTariffCalculator implements TariffCalculator{

    private static final Double tariff = 1.07;

    @Override
    public double calculateTariff(int fromHrs, int toHrs, ParkingSpot parkingSpot) {

        int duration = toHrs - fromHrs;
        Double hourlyCharge = parkingSpot.getHourlyCharge();

        return duration * hourlyCharge * tariff;
    }
}
