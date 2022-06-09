package com.nguonchhay.week5solution3;

public class Aba implements PaymentInterface {

    private double amount;

    public Aba(double amount) {
        this.amount = amount;
    }

    @Override
    public void pay() {
        System.out.println("ABA pay with amount: " + this.amount);
    }

    @Override
    public double getPayAmount() {
        return this.amount;
    }

    @Override
    public String getBankType() {
        return "aba";
    }
}
