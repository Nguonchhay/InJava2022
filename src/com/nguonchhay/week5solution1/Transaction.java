package com.nguonchhay.week5solution1;

import java.util.ArrayList;
import java.util.List;

public class Transaction {

    protected List<Object> transactions = new ArrayList<>();

    public List<Object> getTransactions() {
        return this.transactions;
    }

    public void addTransaction(String paymentOption, double amount) {
        if (paymentOption.equalsIgnoreCase("ABA")) {
            Aba obj = new Aba(amount);
            this.transactions.add(obj);
        } else if (paymentOption.equalsIgnoreCase("Wing")) {
            this.transactions.add(new Wing(amount));
        } else if (paymentOption.equalsIgnoreCase("ACELEDA")) {
            this.transactions.add(new Aceleda(amount));
        } else if (paymentOption.equalsIgnoreCase("Prince")) {
            this.transactions.add(new Prince(amount));
        }
    }
}
