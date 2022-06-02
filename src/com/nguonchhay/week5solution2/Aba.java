package com.nguonchhay.week5solution2;

public class Aba extends AbstractPayment {

    public Aba(double amount) {
        super.setAmount(amount);
    }

    @Override
    void pay() {
        System.out.println("ABA pay with amount: " + super.getAmount());
    }
}
