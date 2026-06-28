
import com.thorn.banking.model.Account;
import com.thorn.banking.repository.FileAccountRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileAccountRepositoryTest {

    @Test
    void shouldSaveAndFindAccount() {

        FileAccountRepository repo = new FileAccountRepository();

        Account account = new Account(
                "9999",
                "Test User",
                "hash",
                100,
                0,
                false
        );

        repo.saveAccount(account);

        Account loaded = repo.findById("9999");

        assertNotNull(loaded);
        assertEquals("Test User", loaded.getOwnerName());
        assertEquals(100, loaded.getBalance());

    }

}