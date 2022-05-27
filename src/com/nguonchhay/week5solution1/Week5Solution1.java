package com.nguonchhay.week5solution1;

import java.util.List;

public class Week5Solution1 {
    public static void demo() {
        System.out.println("Week 5 Solution 1");

        Transaction transactionData = new Transaction();
        transactionData.addTransaction("Wing", 10.0);
        transactionData.addTransaction("Wing", 5.0);
        transactionData.addTransaction("Aba", 8.0);
        transactionData.addTransaction("ABA", 15.5);
        transactionData.addTransaction("ACELEDA", 30.0);
        transactionData.addTransaction("ABA", 25.0);
        transactionData.addTransaction("Wing", 2.5);
        transactionData.addTransaction("ABA", 50.0);
        transactionData.addTransaction("Prince", 21.0);

        // Display
        displayAllTransaction(transactionData.transactions);

        task2(transactionData.transactions);
        task3(transactionData.transactions);
    }

    public static void displayAllTransaction(List<Object> transactions) {
        System.out.println("All Transactions");
        transactions.forEach(bank -> {
            if (bank instanceof Aba) {
                Aba obj = (Aba)bank;
                obj.pay();
            } else if (bank instanceof Wing) {
                Wing obj = (Wing)bank;
                obj.doPayment();
            } else if (bank instanceof Aceleda) {
                Aceleda obj = (Aceleda)bank;
                obj.executeTransaction();
            } else if (bank instanceof Prince) {
                Prince obj = (Prince)bank;
                obj.pay();
            }
        });
    }

    public static void task2(List<Object> transactions) {
        System.out.println("Display number transaction via ABA");
        int count = 0;
        for (Object bankPayment : transactions) {
            if (bankPayment instanceof Aba) {
                count++;
            }
        }
        System.out.println("Total = " + count);
    }

    public static List<Object> sortTransactionDescending(List<Object> transactions) {
        int size =  transactions.size();
        for (int i = 0; i < size - 1; i++) {
            for (int k = i + 1; k < size; k++) {
                Object bankI = transactions.get(i);
                double amountI = 0.0;

                if (bankI instanceof Aba) {
                    Aba obj = (Aba)bankI;
                    amountI = obj.getAmount();
                } else if (bankI instanceof Wing) {
                    Wing obj = (Wing)bankI;
                    amountI = obj.getTotalPrice();
                } else if (bankI instanceof Aceleda) {
                    Aceleda obj = (Aceleda)bankI;
                    amountI = obj.getTransactionAmount();
                } else if (bankI instanceof Prince) {
                    Prince obj = (Prince)bankI;
                    amountI = obj.getAmount();
                }

                Object bankK = transactions.get(k);
                double amountK = 0.0;

                if (bankK instanceof Aba) {
                    Aba obj = (Aba)bankK;
                    amountK = obj.getAmount();
                } else if (bankK instanceof Wing) {
                    Wing obj = (Wing)bankK;
                    amountK = obj.getTotalPrice();
                } else if (bankK instanceof Aceleda) {
                    Aceleda obj = (Aceleda)bankK;
                    amountK = obj.getTransactionAmount();
                } else if (bankK instanceof Prince) {
                    Prince obj = (Prince)bankK;
                    amountK = obj.getAmount();
                }

                if (amountI < amountK) {
                    Object swap = transactions.get(i);
                    transactions.set(i, transactions.get(k));
                    transactions.set(k, swap);
                }
            }
        }

        return transactions;
    }

    public static void task3(List<Object> transactions) {
        System.out.println("Display all transactions sort by total price descending");
        List<Object> sortedTransactions = sortTransactionDescending(transactions);
        displayAllTransaction(sortedTransactions);
    }
}
