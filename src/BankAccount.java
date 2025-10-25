import java.util.concurrent.atomic.AtomicInteger;

public class BankAccount {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1000);
    private final int accountNumber;
    private final String accountHolderName;
    private double balance;

    public BankAccount(String accountHolderName, double initialDeposit) {
        this.accountNumber = ID_GENERATOR.getAndIncrement();
        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive!");
            return;
        }
        balance += amount;
        System.out.println("Deposited $" + amount + " successfully.");
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive!");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance!");
            return;
        }
        balance -= amount;
        System.out.println("Withdrew $" + amount + " successfully.");
    }

    @Override
    public String toString() {
        return "Account No: " + accountNumber +
                " | Holder: " + accountHolderName +
                " | Balance: $" + String.format("%.2f", balance);
    }
}
