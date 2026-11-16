package gr.ihu.omada12.crypto.model.cipher;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Υλοποιεί: ENC-01, ENC-02, ENC-03, NFR-01, NFR-06 (έλεγχος AES-256-GCM κειμένου)

/** Tests του AES με κωδικό (AesCipher) και με κλειδί (AesKeyCipher). Αρίθμηση TC του 2.4. */
class AesCipherTest {
    private final AesCipher aes = new AesCipher();

    @Test // ENC-01/02: ελληνικό κείμενο πάει και έρχεται ίδιο
    void passwordRoundTripWithGreekText() throws CryptoException {
        String secret = "Καλημέρα κόσμε — 2026!";
        assertEquals(secret, aes.decrypt(aes.encrypt(secret, "σωστός-κωδικός"), "σωστός-κωδικός"));
    }

    @Test // TC-15 (UC-02, ροή 6a1): λάθος κωδικός → αποτυχία, όχι «σκουπίδι»
    void wrongPasswordFailsInsteadOfReturningGarbage() throws CryptoException {
        String c = aes.encrypt("μήνυμα", "κωδικός-1");
        CryptoException e = assertThrows(CryptoException.class, () -> aes.decrypt(c, "κωδικός-2"));
        assertEquals("error.wrongKeyOrCorrupted", e.getMessageKey());
    }

    @Test // TC-11 / NFR-01: νέο τυχαίο salt/IV σε κάθε κρυπτογράφηση
    void sameInputGivesDifferentCipherTexts() throws CryptoException {
        String c1 = aes.encrypt("ίδιο", "pw");
        String c2 = aes.encrypt("ίδιο", "pw");
        assertNotEquals(c1, c2);
        assertEquals("ίδιο", aes.decrypt(c1, "pw"));
        assertEquals("ίδιο", aes.decrypt(c2, "pw"));
    }

    @Test // TC-14 (UC-02, ροή 5a2): κρυπτοκείμενο που δεν είναι Base64
    void invalidBase64IsReported() {
        CryptoException e = assertThrows(CryptoException.class, () -> aes.decrypt("@@@ not base64 @@@", "pw"));
        assertEquals("error.notBase64", e.getMessageKey());
    }

    @Test // TC-09 (UC-01, ροή 5a2): κενός κωδικός
    void emptyPasswordIsRejected() {
        CryptoException e = assertThrows(CryptoException.class, () -> aes.encrypt("κείμενο", ""));
        assertEquals("error.emptyPassword", e.getMessageKey());
    }

    @Test // TC-25: μη έγκυρο κλειδί AES (μορφή ή μήκος)
    void invalidAesKeyIsRejected() {
        CryptoException e = assertThrows(CryptoException.class, () -> new AesKeyCipher().validateKey("abc"));
        assertTrue(e.getMessageKey().startsWith("error.aesKey"), e.getMessageKey());
    }

    @Test // TC-13 / NFR-06: κείμενο 10.000 χαρακτήρων σε < 1 s
    void tenThousandCharactersUnderOneSecond() throws CryptoException {
        String text = "α".repeat(10_000);
        long start = System.nanoTime();
        String c = aes.encrypt(text, "pw");
        long ms = (System.nanoTime() - start) / 1_000_000;
        assertEquals(text, aes.decrypt(c, "pw"));
        assertTrue(ms < 1000, "Η κρυπτογράφηση πήρε " + ms + " ms");
    }
}
