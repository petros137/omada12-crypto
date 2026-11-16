package gr.ihu.omada12.crypto.model.crypto;

import gr.ihu.omada12.crypto.model.cipher.CryptoException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

// Υλοποιεί: ENC-03, NFR-02 (έλεγχος PBKDF2 και PasswordBox)

/** TC-12: PBKDF2-HMAC-SHA256, 600.000 επαναλήψεις, salt 16 bytes, κλειδί 32 bytes (απόφαση #7). */
class KeyDerivationTest {
    private final KeyDerivation kd = new KeyDerivation();

    @Test
    void usesOwaspParameters() {
        assertEquals(600_000, KeyDerivation.ITERATIONS);
        assertEquals(16, kd.newSalt().length);
    }

    @Test
    void sameSaltGivesSameKeyDifferentSaltDifferentKey() throws CryptoException {
        byte[] salt = kd.newSalt();
        byte[] k1 = kd.derive("pw".toCharArray(), salt).getEncoded();
        byte[] k2 = kd.derive("pw".toCharArray(), salt).getEncoded();
        byte[] k3 = kd.derive("pw".toCharArray(), kd.newSalt()).getEncoded();
        assertEquals(32, k1.length);
        assertArrayEquals(k1, k2);
        assertFalse(Arrays.equals(k1, k3));
    }

    @Test
    void emptyPasswordIsRejected() {
        CryptoException e = assertThrows(CryptoException.class, () -> kd.derive(new char[0], kd.newSalt()));
        assertEquals("error.emptyPassword", e.getMessageKey());
    }

    @Test // NFR-01: το GCM ανιχνεύει αλλοίωση ενός bit
    void passwordBoxDetectsTampering() throws CryptoException {
        PasswordBox box = new PasswordBox();
        byte[] sealed = box.seal("data".getBytes(), "pw".toCharArray());
        sealed[sealed.length - 1] ^= 1;
        CryptoException e = assertThrows(CryptoException.class, () -> box.open(sealed, "pw".toCharArray()));
        assertEquals("error.wrongKeyOrCorrupted", e.getMessageKey());
    }
}
