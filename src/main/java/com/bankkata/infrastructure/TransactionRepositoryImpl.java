package com.bankkata.infrastructure;

import com.bankkata.domain.Transaction;
import com.bankkata.domain.TransactionRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransactionRepositoryImpl implements TransactionRepository {
    private final List<Transaction> transactions = new ArrayList<>();

    @Override
    public void addTransaction(int amount) {
        int currentBalance = getBalance(); // Get the current balance from the Account

        transactions.add(new Transaction(LocalDate.now(), amount, currentBalance)); // Balance is handled in Account class

    }

    @Override
    public List<Transaction> getAllTransactions() {
        return new ArrayList<>(transactions); // Returning a copy to prevent external modification
    }

    private int getBalance() {
        // You can calculate balance by summing the transaction amounts or store it separately
        int balance = 0;
        for (Transaction transaction : transactions) {
            balance += transaction.getAmount();
        }
        return balance;
    }
}
