## Bank Kata Solution

This repository contains the implementation for the Bank Kata challenge. Below is a description of the key classes and their responsibilities.

### `Transaction.java` (Domain)
- **Description**: Represents a financial transaction. Each transaction has a date, an amount, and the balance after the transaction is applied.
- **Functionality**:
    - `getDate()` – Returns the date of the transaction.
    - `getAmount()` – Returns the amount of the transaction (positive for deposits, negative for withdrawals).
    - `getBalance()` – Returns the balance after the transaction is applied.

### `TransactionRepository.java` (Domain)
- **Description**: Defines the contract for a repository that manages transactions.
- **Functionality**:
    - `addTransaction(int amount)` – Adds a new transaction with the given amount to the repository.
    - `getAllTransactions()` – Returns a list of all transactions in the repository.

### `Account.java` (Domain)
- **Description**: Represents a bank account. It allows deposits and withdrawals, tracks the balance, and prints a statement of transactions.
- **Functionality**:
    - `deposit(int amount)` – Deposits the given amount into the account and records the transaction.
    - `withdraw(int amount)` – Withdraws the given amount from the account and records the transaction.
    - `getBalance()` – Returns the current balance of the account.
    - `printStatement()` – Prints the transaction history using the `StatementPrinter`.

### `TransactionRepositoryImpl.java` (Infrastructure)
- **Description**: Implements the `TransactionRepository` interface using an `ArrayList` to store transactions.
- **Functionality**:
    - `addTransaction(int amount)` – Adds a new transaction to the repository, including the current balance.
    - `getAllTransactions()` – Retrieves all transactions in the repository.

### `StatementPrinter.java` (Service)
- **Description**: Responsible for printing the statement of transactions for a bank account in a human-readable format.
- **Functionality**:
    - `print(List<Transaction> transactions)` – Prints the transaction history with the date, amount, and balance.
    - `formatTransaction(Transaction transaction)` – Formats a single transaction into a string for display.

### Example Workflow:
1. Create an account with a `TransactionRepository` and `StatementPrinter`.
2. Make a deposit or withdrawal with `deposit()` or `withdraw()`.
3. View the account balance with `getBalance()`.
4. Print the transaction history with `printStatement()`.


****************************************** Mockist TESTS

### `AccountTest.java` (Test Class)

- **Description**: This test class verifies the functionality of the `Account` class using the JUnit 5 testing framework and Mockito for mocking dependencies.
- **Functionality**:
    - `setUp()` – Initializes the mock dependencies (`TransactionRepository` and `StatementPrinter`) and the `Account` instance before each test.

    - **Test Methods**:
        - `depositShouldStoreTransaction()` – Verifies that when a deposit is made, a corresponding transaction is added to the `TransactionRepository`.
        - `withdrawShouldStoreTransaction()` – Verifies that when a withdrawal is made, a corresponding transaction is added to the `TransactionRepository` (with a negative amount).
        - `printStatementShouldPrintTransactions()` – Verifies that when the statement is printed, the transactions from the `TransactionRepository` are correctly passed to the `StatementPrinter`.

- **Testing Framework**: JUnit 5 with Mockito for mocking external dependencies and verifying interactions with the `TransactionRepository` and `StatementPrinter`.

### Example Test Output:
- The tests ensure that:
    - Transactions are added correctly when deposits or withdrawals are made.
    - The statement is printed correctly by passing the right transactions to the `StatementPrinter`.
