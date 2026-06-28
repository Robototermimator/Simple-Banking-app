package com.thorn.banking.service;

//Class imports
import com.thorn.banking.model.Account;
import com.thorn.banking.util.ConsoleHelper;
import com.thorn.banking.security.PasswordHasher;
import com.thorn.banking.repository.FileAccountRepository;

//Java imports
import java.util.UUID;

public class BankService {
    private FileAccountRepository accountRepository = new FileAccountRepository();
    private ConsoleHelper console = new ConsoleHelper();
    private AuthService authService = new AuthService();
    

    //Create a new account + PIN
    public void createAccount(){
        String name = console.getString("Enter account holder name: ");
        String pin = console.getString("Enter 4-digit PIN: ");

        // Generate a unique account number and hash the PIN
        String accountNumber = UUID.randomUUID().toString().substring(0, 5);
        String hashedPin = PasswordHasher.hash(pin);

        Account account = new Account(accountNumber, name, hashedPin, 0.0, 0 , false);
        accountRepository.saveAccount(account);

        System.out.println("Account created successfully! " + "\n Account Number: " + accountNumber);

    }

    // Login method to authenticate users
    private Account login() {
        String acc = console.getString("Enter account number: ");
        String pin = console.getString("Enter PIN:");

        Account account = accountRepository.findById(acc);
        if (account == null) {
            System.out.println("Account not found");
            return null;
        }

        if (!authService.authenticate(account, pin)) {
            return null;
        }
        return account;
    }

    // Deposit money into an account
    public void deposit(){

        Account account = login();
        if (account == null) return;

        
        double amount = console.getDouble("Enter deposit amount: ");
        account.deposit(amount);
        System.out.println("Deposit successful");
    }

    // Withdraw money from an account
    public void withdraw(){

        Account account = login();

        if (account == null) return;

        double amount = console.getDouble("Enter withdrawal amount: ");

        if (account.getBalance() >= amount){
            account.withdraw(amount);
            System.out.println("Withdrawal successful");
            } else {
                System.out.println("Insufficient funds");
            }  
        }
    
    // Check account balance
    public void checkBalance(){
        Account account = login();
        if (account == null) return;

        if (account != null){
            System.out.println("Owner: " + account.getOwnerName() + "\n Balance: " + account.getBalance());
        }
        }
    }
