package com.praveen10.learn.java.LowLevelDesign.parkinglot;

public class CashPayment implements Payment{

    @Override
    public boolean payment(Double amount) {
        System.out.println("Paid the amount ₹" + amount + "  via Cash...");
        return true;
    }
}
