package com.nguonchhay.week5solution2;

import java.util.ArrayList;
import java.util.List;

public class TransactionFactory {
    protected List<AbstractPayment> transactions = new ArrayList<>();

    public List<AbstractPayment> getTransactions() {
        return this.transactions;
    }

    public void addTransaction(String paymentOption, double amount) {
        if (paymentOption.equalsIgnoreCase("ABA")) {
            this.transactions.add(new Aba(amount));
        } else if (paymentOption.equalsIgnoreCase("Wing")) {
            this.transactions.add(new Wing(amount));
        } else if (paymentOption.equalsIgnoreCase("Prince")) {
            this.transactions.add(new Prince(amount));
        } else if (paymentOption.equalsIgnoreCase("cimb")) {
            this.transactions.add(new Cimb(amount));
        }
    }
}
