package com.bankkata.domain;

import java.util.List;

public interface TransactionRepository {
    void addTransaction(int amount);
    List<Transaction> getAllTransactions();
}
