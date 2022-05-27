package com.nguonchhay.week5solution1;

// Load ABA library or Call ABA API
public class Aba {
    protected double amount;

    public Aba(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return this.amount;
    }

    public void pay() {
        // process payment
        System.out.println("ABA pay with amount: " + this.getAmount());
    }
}
