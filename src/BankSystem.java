
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankSystem {
    private Map<Integer, BankAccount> accounts = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        int choice;
        do {
            System.out.println("\n=== Bank Account Management System ===");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Balance");
            System.out.println("5. View All Accounts");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> viewBalance();
                case 5 -> viewAllAccounts();
                case 0 -> System.out.println("Thank you for using the system!");
                default -> System.out.println("Invalid choice, try again!");
            }
        } while (choice != 0);
    }

    private void createAccount() {
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();
        System.out.print("Enter initial deposit: ");
        double deposit = scanner.nextDouble();

        BankAccount account = new BankAccount(name, deposit);
        accounts.put(account.getAccountNumber(), account);

        System.out.println("Account created successfully!");
        System.out.println(account);
    }

    private void deposit() {
        BankAccount account = getAccount();
        if (account != null) {
            System.out.print("Enter deposit amount: ");
            double amount = scanner.nextDouble();
            account.deposit(amount);
        }
    }

    private void withdraw() {
        BankAccount account = getAccount();
        if (account != null) {
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            account.withdraw(amount);
        }
    }

    private void viewBalance() {
        BankAccount account = getAccount();
        if (account != null) {
            System.out.println("Current balance: ₹" + account.getBalance());
        }
    }

    private void viewAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }
        System.out.println("\nAll Accounts:");
        accounts.values().forEach(System.out::println);
    }

    private BankAccount getAccount() {
        System.out.print("Enter account number: ");
        int accNo = scanner.nextInt();
        BankAccount account = accounts.get(accNo);
        if (account == null) {
            System.out.println("Account not found!");
        }
        return account;
    }

    public static void main(String[] args) {
        new BankSystem().start();
    }
}
