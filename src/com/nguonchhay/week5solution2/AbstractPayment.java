package com.nguonchhay.week5solution2;

public abstract class AbstractPayment {
    protected double amount;

    abstract void pay();

    protected double getAmount() {
        return this.amount;
    }

    protected void setAmount(double amount) {
        this.amount = amount;
    }
}
