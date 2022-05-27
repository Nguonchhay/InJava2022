package com.nguonchhay.week5solution1;

// Load Prince library or Call Prince API
public class Prince {
    protected double amount;

    public Prince(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return this.amount;
    }

    public void pay() {
        // process payment
        System.out.println("Prince pay with amount: " + this.getAmount());
    }
}
