package com.nguonchhay.week5solution2;

public class Cimb extends AbstractPayment {

    public Cimb(double fee) {
        super.setAmount(fee);
    }

    @Override
    void pay() {
        System.out.println("CIMB pay with amount: " + super.getAmount());
    }
}
