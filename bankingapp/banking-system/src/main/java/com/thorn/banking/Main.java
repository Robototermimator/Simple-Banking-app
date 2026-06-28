package com.thorn.banking;

import com.thorn.banking.service.BankService;
import com.thorn.banking.util.ConsoleHelper;

public class Main {
    public static void main(String[] args) {
        BankService bankService = new BankService();
        ConsoleHelper console = new ConsoleHelper();

        while (true){

            System.out.println("\n ====== Banking System Menu ======");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");

            int choice = console.getInt("Choose option:");

            switch (choice){
                case 1 -> bankService.createAccount();
                case 2 -> bankService.deposit();
                case 3 -> bankService.withdraw();
                case 4 -> bankService.checkBalance();
                case 5 -> {
                    System.out.println("Exiting the application....");
                return;
                }
                default -> System.out.println("Invalid option. Please try again.");
        }

    }
}
}