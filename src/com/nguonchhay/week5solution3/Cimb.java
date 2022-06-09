package com.nguonchhay.week5solution3;

public class Cimb implements PaymentInterface {

    private double amount;

    public Cimb(double amount) {
        this.amount = amount;
    }

    @Override
    public void pay() {
        System.out.println("CIMB pay with amount: " + this.amount);
    }

    @Override
    public double getPayAmount() {
        return this.amount;
    }

    @Override
    public String getBankType() {
        return "cimb";
    }
}
