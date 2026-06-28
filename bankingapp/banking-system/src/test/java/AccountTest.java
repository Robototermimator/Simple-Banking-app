

import org.junit.jupiter.api.Test;

import com.thorn.banking.model.Account;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void depositShouldIncreaseBalance() {

        Account account = new Account(
                "1234",
                "Thorn",
                "hash",
                0.0,
                0,
                false
        );

        account.deposit(500);

        assertEquals(500, account.getBalance());
    }

    @Test
    void withdrawShouldDecreaseBalance() {

        Account account = new Account(
                "1234",
                "Thorn",
                "hash",
                1000,
                0,
                false
        );

        account.withdraw(250);

        assertEquals(750, account.getBalance());
    }

}