package com.praveen10.learn.java.LowLevelDesign.parkinglot;

import java.util.Date;

public class ExitTerminal {
    private Terminal terminal;

    public ExitTerminal(Terminal terminal){
        this.terminal = terminal;
    }

    public boolean acceptTicket(ParkingTicket parkingTicket, Payment payment, TariffCalculator tariffCalculator){
        ParkingSpot spot = parkingTicket.getParkingSpot();

        Double tariff = tariffCalculator.calculateTariff(
                parkingTicket.getIssueTime().getHours(), new Date().getHours() + 20, parkingTicket.getParkingSpot());

        payment.payment(tariff);

        System.out.println("Ticket Accepted...  Total price: " + tariff );

        return terminal.releaseParkingSpot(spot);
    }
}
