package com.bankkata;

import com.bankkata.domain.TransactionRepository;
import com.bankkata.domain.Transaction;
import com.bankkata.domain.Account;
import com.bankkata.service.StatementPrinter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
//@ExtendWith(MockitoExtension.class) // Enable Mockito annotations
class AccountTest {
    private TransactionRepository transactionRepository;
    private StatementPrinter statementPrinter;
    private Account account;

    @BeforeEach
    void setUp() {
        transactionRepository = mock(TransactionRepository.class); // Mocking dependency
        statementPrinter = mock(StatementPrinter.class);
        account = new Account(transactionRepository, statementPrinter);
    }

    @Test
    void depositShouldStoreTransaction() {
        account.deposit(1000);

        verify(transactionRepository).addTransaction(1000);
    }

    @Test
    void withdrawShouldStoreTransaction() {
        account.withdraw(500);

        verify(transactionRepository).addTransaction(-500);
    }

    @Test
    void printStatementShouldPrintTransactions() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction(LocalDate.of(2012, 1, 10), 1000, 1000),
                new Transaction(LocalDate.of(2012, 1, 13), 2000, 3000),
                new Transaction(LocalDate.of(2012, 1, 14), -500, 2500)
        );

        when(transactionRepository.getAllTransactions()).thenReturn(transactions);

        account.printStatement();

        verify(statementPrinter).print(transactions);
    }
}
