package com.nguonchhay.week5solution3;

public class Prince implements PaymentInterface {

    private double amount;

    public Prince(double amount) {
        this.amount = amount;
    }

    @Override
    public void pay() {
        System.out.println("Prince pay with amount: " + this.amount);
    }

    @Override
    public double getPayAmount() {
        return this.amount;
    }

    @Override
    public String getBankType() {
        return "prince";
    }
}
