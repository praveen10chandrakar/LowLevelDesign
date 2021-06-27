package com.praveen10.learn.java.LowLevelDesign.parkinglot;

public class ParkingLotSystem {

    public static ParkingSpot getRandomParkingSpotType(int id){
        int random = (int)(Math.random() * 4);
        switch (random){
            case 0: return new HandicappedParkingSpot(id);
            case 1: return new LargeParkingSpot(id);
            case 2: return new CompactParkingSpot(id);
            case 3: return new MotorCycleParkingSpot(id);
            default: return new CompactParkingSpot(id);
        }
    }

    public static void main(String[] args) {
        System.out.println("Parking Log System Online.....");

        // Create all the terminals object
        Terminal terminal0 = new Terminal(0);
        Terminal terminal1 = new Terminal(1);
        Terminal terminal2 = new Terminal(2);
        Terminal terminal3 = new Terminal(3);

        for (int i = 1; i <= 100; i++){
            terminal0.addToAvailableParkingSpot(getRandomParkingSpotType(i));
            terminal1.addToAvailableParkingSpot(getRandomParkingSpotType(i));
            terminal2.addToAvailableParkingSpot(getRandomParkingSpotType(i));
            terminal3.addToAvailableParkingSpot(getRandomParkingSpotType(i));
        }

        EntryTerminal entryTerminal = new EntryTerminal(terminal0);
        ExitTerminal exitTerminal = new ExitTerminal(terminal0);

        // Print parking layout
        terminal0.printLayout();

        // Getting first Compact type
        ParkingTicket parkingTicketCompact1 = entryTerminal.getTicket("COMPACT");
        ParkingTicket parkingTicketCompact2 = entryTerminal.getTicket("COMPACT");
        ParkingTicket parkingTicketCompact3 = entryTerminal.getTicket("COMPACT");
        ParkingTicket parkingTicketCompact4 = entryTerminal.getTicket("COMPACT");

        Payment creditCardPayment = new CreditCardPayment();

        // Getting Second Compact Type
        ParkingTicket parkingTicketLarge1 = entryTerminal.getTicket("LARGE");
        ParkingTicket parkingTicketMotorCycle1 = entryTerminal.getTicket("MOTORCYCLE");
        ParkingTicket parkingTicketCompact5 = entryTerminal.getTicket("COMPACT");

        Payment cashPayment = new CashPayment();

        // Releasing the parkingTicket parkingTicketCompact5
        exitTerminal.acceptTicket(parkingTicketCompact5, cashPayment, new WeekdayTariffCalculator());

        // Releasing the parkingTicket parkingTicketCompact1
        exitTerminal.acceptTicket(parkingTicketCompact1, creditCardPayment, new WeekdayTariffCalculator());

        // Releasing the parkingTicket parkingTicketCompact3
        exitTerminal.acceptTicket(parkingTicketCompact3, creditCardPayment, new WeekdayTariffCalculator());

        // Releasing the parkingTicket parkingTicketCompact2
        exitTerminal.acceptTicket(parkingTicketCompact2, creditCardPayment, new WeekendTariffCalculator());

        // Releasing the parkingTicket parkingTicketCompact
        exitTerminal.acceptTicket(parkingTicketLarge1, cashPayment, new WeekdayTariffCalculator());

        // Releasing the parkingTicket parkingTicketCompact4
        exitTerminal.acceptTicket(parkingTicketCompact4, cashPayment, new WeekendTariffCalculator());

        // Releasing the parkingTicket parkingTicketCompact4
        exitTerminal.acceptTicket(parkingTicketMotorCycle1, cashPayment, new WeekendTariffCalculator());
    }
}
