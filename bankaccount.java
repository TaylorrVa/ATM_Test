
import java.util.Stack;

public abstract class BankAccount {
    private int accountNumber;
    private int clientID;
    protected double balance;
    private Stack<Transaction> transactionHistory;

    public BankAccount(int accountNumber,  int clientID, double initialBalance) {
        this.accountNumber = accountNumber;
        this.clientID = clientID;
        this.balance = initialBalance;
        this.transactionHistory = new Stack<Transaction>();
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getClientID() {
        return clientID;
    }

    public double getBalance() {
        return balance;
    }

    public void updateTransaction( String type, double amount) {
        transactionHistory.push(new Transaction(type, amount));
    }

    public Stack<Transaction> getTransactionHistory() {
        return transactionHistory; 
    }

    protected void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            updateTransaction("deposit", amount);
        } else {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid withdrawal amount.");
        } else if (amount > balance) {
            throw new IllegalArgumentException("Transaction cancelled. Insufficient funds.");
        } else {
            balance -= amount;
            updateTransaction("withdraw", amount);
        }
    }

    public abstract void applyInterest();

}
