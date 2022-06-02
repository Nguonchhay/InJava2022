package com.nguonchhay.week5solution2;

public class Prince extends AbstractPayment {

    public Prince(double amount) {
        super.setAmount(amount);
    }

    @Override
    void pay() {
        System.out.println("Prince pay with amount: " + this.getAmount());
    }
}
