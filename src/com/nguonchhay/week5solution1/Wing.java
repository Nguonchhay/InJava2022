package com.nguonchhay.week5solution1;

// Load Wing library or Call Wing API
public class Wing {
    protected double totalPrice;

    public Wing(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    public void doPayment() {
        // process payment
        System.out.println("Wing pay with amount: " + this.getTotalPrice());
    }
}
