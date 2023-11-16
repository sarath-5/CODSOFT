import java.util.Scanner;
class BankAccount 
{
    private double balance;
    public BankAccount(double initialBalance) 
    {
        balance = initialBalance;
    }
    public double getBalance() 
    {
        return balance;
    }
    public void deposit(double amount) 
    {
        if (amount > 0) 
        {
            balance += amount;
            System.out.println("Deposited: Rs." + amount);
        } 
        else 
        {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) 
    {
        if (amount > 0 && amount <= balance)
        {
            balance -= amount;
            System.out.println("Withdrawn: Rs." + amount);
        } else {
            System.out.println("Invalid amount or Insufficient balance!");
        }
    }
}
class ATM {
    private BankAccount account;
    private Scanner scanner;
    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println('\n'+"ATM Services:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. EXIT");
        System.out.print('\n'+"Enter the service needed: ");
    }

    public void run() {
        boolean isRunning = true;

        while (isRunning) {
            displayMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Account Balance: Rs." + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount : Rs.");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount Rs.");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                case 4:
                    isRunning = false;
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid selection! Please select a valid option.");
                    break;
            }
        }
    }

    public void close() {
        scanner.close();
    }
}

public class Bank {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0); 
        ATM atm = new ATM(userAccount);
        atm.run();
        atm.close();
    }
}
