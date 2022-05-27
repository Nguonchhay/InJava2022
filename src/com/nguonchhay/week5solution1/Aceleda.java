package com.nguonchhay.week5solution1;

public class Aceleda {

    protected double transactionAmount;

    public Aceleda(double amount) {
        this.transactionAmount = amount;
    }

    public double getTransactionAmount() {
        return this.transactionAmount;
    }

    public void executeTransaction() {
        // process payment
        System.out.println("Aceleda pay with amount: " + this.getTransactionAmount());
    }
}
