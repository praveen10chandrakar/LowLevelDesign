package com.praveen10.learn.java.LowLevelDesign.parkinglot;

public class CreditCardPayment implements Payment{

    private String cardNumber;
    private String cVV;
    private String cardHolderNumber;

    public CreditCardPayment(){

    }

    public CreditCardPayment(String cardNumber, String cVV, String cardHolderNumber) {
        this.cardNumber = cardNumber;
        this.cVV = cVV;
        this.cardHolderNumber = cardHolderNumber;
    }

    @Override
    public boolean payment(Double amount) {
        System.out.println("Paid the amount ₹" + amount + "  via Credit Card...");
        return true;
    }
}
