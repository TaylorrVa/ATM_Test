

public class CheckingAccount extends BankAccount {
    private double overdraftLimit;

    public CheckingAccount(int accountNumber, int clientID, double initialBalance, double overdraftLimit) {
        super(accountNumber, clientID, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit(int creditScore) {
        return calculateOverdraftLimit(creditScore);
    }
    

    @Override
    public void withdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid withdrawal amount.");
        } else if (amount > getBalance() + overdraftLimit) {
            throw new IllegalArgumentException("Transaction cancelled. Insufficient funds.");
        } else {
            balance -= amount;
            updateTransaction("withdraw", amount);
        }
    }
    public void purchase(double amount) {
        withdraw(amount);
    }   

    @Override
    public void applyInterest() {
        // No interest applied for checking accounts
    }

    public boolean canOpenAccount(double initialBalance) {
        return initialBalance >= 50;
    }

    public static double calculateOverdraftLimit(int creditScore) {
        if (creditScore >= 800) {
            return 1000;
        } else if (creditScore >= 700) {
            return 500;
        } else if (creditScore >= 600) {
            return 200;
        } else {
            return 0;
        }
    }
    
    public double getBalance() {
    	return this.balance;
    }

    public String toString() {
        return "CheckingAccount [Account#: " + getAccountNumber() + ", ClientID: " + getClientID() + ", Balance: $" + getBalance() + ", OverdraftLimit: $" + overdraftLimit + "]";
    }
}