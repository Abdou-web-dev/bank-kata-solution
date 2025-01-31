package com.bankkata;

import com.bankkata.domain.TransactionRepository;
import com.bankkata.infrastructure.TransactionRepositoryImpl;  // Import the implementation
import com.bankkata.service.StatementPrinter;
import com.bankkata.domain.Account;

public class Main {
    public static void main(String[] args) {
        // Instantiate the implementation of TransactionRepository
        TransactionRepository transactionRepository = new TransactionRepositoryImpl();

        // Instantiate the StatementPrinter (you can create a simple one or mock it in testing)
        StatementPrinter statementPrinter = new StatementPrinter();

        // Create an Account instance with the TransactionRepositoryImpl
//       Account account = new Account(transactionRepository, statementPrinter);

        // Create an Account instance
        Account account = new Account(transactionRepository, statementPrinter);

        // Test Deposits and Withdrawals
        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);
        account.withdraw(30);
        account.withdraw(141);
        account.deposit(6512);
        account.deposit(10);
        account.withdraw(236);

        // Print the statement
        account.printStatement();

    }
}

