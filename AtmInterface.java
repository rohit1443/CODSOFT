import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double checkBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount account;
    private Scanner scanner = new Scanner(System.in);

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void run() {
        while (true) {
            displayMenu();
            System.out.print("Please select an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = Double.parseDouble(scanner.nextLine());
                    if (account.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Insufficient balance or invalid amount.");
                    }
                    break;
                case "2":
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = Double.parseDouble(scanner.nextLine());
                    if (account.deposit(depositAmount)) {
                        System.out.println("Deposit successful.");
                    } else {
                        System.out.println("Invalid amount.");
                    }
                    break;
                case "3":
                    double balance = account.checkBalance();
                    System.out.println("Your account balance is: " + balance);
                    break;
                case "4":
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }
}

public class AtmInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your initial account balance: ");
        double initialBalance = Double.parseDouble(scanner.nextLine());

        BankAccount userAccount = new BankAccount(initialBalance);
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}
