package com.thorn.banking.service;

import com.thorn.banking.model.Account;
import com.thorn.banking.security.PasswordHasher;

public class AuthService {

    public boolean authenticate(Account account, String pin){

        if (account.isLocked()){
            System.out.println("Account is locked due to multiple failed attempts.");
            return false;
        }
        if (PasswordHasher.verify(pin, account.getPinHash())){
            account.resetFailedAttempts();
            return true;

        }else {
            account.incrementFailedAttempts();
            System.out.println("Incorrect PIN");

            if (account.isLocked()) {
                System.out.println("Account locked after 3 failed attempts!");
            }

            return false;
        }
    }
    
}
