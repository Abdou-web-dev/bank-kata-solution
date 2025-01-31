package com.bankkata.domain;

import com.bankkata.service.StatementPrinter;

import java.time.LocalDate;
import java.util.List;

public class Account {
    private final TransactionRepository transactionRepository;
    private final StatementPrinter statementPrinter;
    private int balance = 0;

    public Account(TransactionRepository transactionRepository, StatementPrinter statementPrinter) {
        this.transactionRepository = transactionRepository;
        this.statementPrinter = statementPrinter;
    }

    public void deposit(int amount) {
        balance += amount;
        transactionRepository.addTransaction(amount);
    }

    public void withdraw(int amount) {
        balance -= amount;
        transactionRepository.addTransaction(-amount);
    }

    public int getBalance() {
        return balance;  // Return the balance field (no need to sum transactions)
    }

    public void printStatement() {
        List<Transaction> transactions = transactionRepository.getAllTransactions();
        statementPrinter.print(transactions);
    }
}
