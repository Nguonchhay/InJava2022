package com.nguonchhay.week5solution3;

public class Wing implements PaymentInterface {

    private double amount;

    public Wing(double amount) {
        this.amount = amount;
    }

    @Override
    public void pay() {
        System.out.println("Wing pay with amount: " + this.amount);
    }

    @Override
    public double getPayAmount() {
        return this.amount;
    }

    @Override
    public String getBankType() {
        return "wing";
    }
}
