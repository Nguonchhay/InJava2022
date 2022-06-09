package com.nguonchhay.week5solution3;

import java.util.ArrayList;
import java.util.List;

public class TransactionFactory {
    protected List<PaymentInterface> transactions = new ArrayList<>();

    public List<PaymentInterface> getTransactions() {
        return this.transactions;
    }

    public void addTransaction(String paymentOption, double amount) {
        if (paymentOption.equalsIgnoreCase("ABA")) {
            this.transactions.add(new Aba(amount));
        } else if (paymentOption.equalsIgnoreCase("Wing")) {
            this.transactions.add(new Wing(amount));
        } else if (paymentOption.equalsIgnoreCase("Prince")) {
            this.transactions.add(new Prince(amount));
        } else if (paymentOption.equalsIgnoreCase("Cimb")) {
            this.transactions.add(new Cimb(amount));
        }
    }
}
