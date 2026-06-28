

import com.thorn.banking.model.Account;
import com.thorn.banking.security.PasswordHasher;
import com.thorn.banking.service.AuthService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthServiceTest {

    @Test
    void authenticateShouldAcceptCorrectPin() {

        String hash = PasswordHasher.hash("1234");

        Account account = new Account(
                "1001",
                "Thorn",
                hash,
                500,
                0,
                false
        );

        AuthService auth = new AuthService();

        assertTrue(auth.authenticate(account, "1234"));

    }

    @Test
    void authenticateShouldRejectWrongPin() {

        String hash = PasswordHasher.hash("1234");

        Account account = new Account(
                "1001",
                "Thorn",
                hash,
                500,
                0,
                false
        );

        AuthService auth = new AuthService();

        assertFalse(auth.authenticate(account, "9999"));

    }

}