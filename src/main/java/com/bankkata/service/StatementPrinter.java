package com.bankkata.service;

import com.bankkata.domain.Transaction;

import java.util.List;

public class StatementPrinter {
    private static final String HEADER = "Date || Amount || Balance";

    public void print(List<Transaction> transactions) {
        System.out.println(HEADER);
        for (Transaction transaction : transactions) {
            System.out.println(formatTransaction(transaction));
        }
    }

    private String formatTransaction(Transaction transaction) {
        return transaction.getDate() + " || " + transaction.getAmount() + " || " + transaction.getBalance();
    }
}
