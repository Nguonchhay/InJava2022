package com.nguonchhay.week5solution3;

import com.nguonchhay.week5solution2.AbstractPayment;

import java.util.List;

public class Week5Solution3 {

    public static void demo() {
        System.out.println("Week 5 Solution 3");

        TransactionFactory transactionData = new TransactionFactory();
        transactionData.addTransaction("Wing", 10.0);
        transactionData.addTransaction("Wing", 5.0);
        transactionData.addTransaction("Aba", 8.0);
        transactionData.addTransaction("ABA", 15.5);
        transactionData.addTransaction("cimb", 20.5);
        transactionData.addTransaction("ABA", 10.5);

        // Display
        displayAllTransaction(transactionData.transactions);

        task2(transactionData.transactions);
        task3(transactionData.transactions);
    }

    public static void displayAllTransaction(List<PaymentInterface> transactions) {
        System.out.println("All Transactions");
        transactions.forEach(bank -> {
            bank.pay();
        });
    }

    public static void task2(List<PaymentInterface> transactions) {
        System.out.println("Display number transaction via ABA");
        int count = 0;
        for (PaymentInterface bank : transactions) {
            if (Aba.class.isInstance(bank)) {
                count++;
            }
//            if (bank.getBankType().equalsIgnoreCase("aba")) {
//                count++;
//            }
        }
        System.out.println("Total = " + count);
    }

    public static List<PaymentInterface> sortTransactionDescending(List<PaymentInterface> transactions) {
        int size =  transactions.size();
        for (int i = 0; i < size - 1; i++) {
            for (int k = i + 1; k < size; k++) {
                if (transactions.get(i).getPayAmount() < transactions.get(k).getPayAmount()) {
                    PaymentInterface swap = transactions.get(i);
                    transactions.set(i, transactions.get(k));
                    transactions.set(k, swap);
                }
            }
        }

        return transactions;
    }

    public static void task3(List<PaymentInterface> transactions) {
        System.out.println("Display all transactions sort by total price descending");
        List<PaymentInterface> sortedTransactions = sortTransactionDescending(transactions);
        displayAllTransaction(sortedTransactions);
    }
}
