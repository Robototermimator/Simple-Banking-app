
import org.junit.jupiter.api.Test;
import com.thorn.banking.security.PasswordHasher;
import static org.junit.jupiter.api.Assertions.*;

class PasswordHasherTest {

    @Test
    void hashShouldAlwaysBeSameForSameInput() {

        String hash1 = PasswordHasher.hash("1234");
        String hash2 = PasswordHasher.hash("1234");

        assertEquals(hash1, hash2);

    }

    @Test
    void verifyShouldReturnTrueForCorrectPin() {

        String hash = PasswordHasher.hash("4321");

        assertTrue(
                PasswordHasher.verify("4321", hash)
        );

    }

    @Test
    void verifyShouldReturnFalseForWrongPin() {

        String hash = PasswordHasher.hash("4321");

        assertFalse(
                PasswordHasher.verify("1111", hash)
        );

    }

}