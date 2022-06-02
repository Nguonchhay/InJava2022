package com.nguonchhay.week5solution2;

public class Wing extends AbstractPayment {

    public Wing(double amount) {
        super.setAmount(amount);
    }

    @Override
    void pay() {
        System.out.println("Wing pay with amount: " + this.getAmount());
    }
}
