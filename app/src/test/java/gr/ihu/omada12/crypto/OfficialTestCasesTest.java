package gr.ihu.omada12.crypto;

import gr.ihu.omada12.crypto.model.cipher.AesCipher;
import gr.ihu.omada12.crypto.model.cipher.CryptoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

// Υλοποιεί: ENC-01, ENC-02, ENC-03, NFR-01 (τα επίσημα test cases του Παραδοτέου 2)

/**
 * Τα 5 επίσημα test cases του docs/P2/2.4-test-cases.md § 1 (απόφαση #20).
 * Κάθε μέθοδος = μία γραμμή του πίνακα Test Case # · Description · Test Data · Expected Result.
 * Μπαίνουν σταδιακά, μαζί με τον κώδικα που ελέγχουν: TC-02 με το model/file (Ε6),
 * TC-03 με το Secure Vault (Ε7), TC-04/TC-05 με υπογραφή και στεγανογραφία (Ε8).
 */
class OfficialTestCasesTest {

    @Test
    @DisplayName("TC-01 · UC-01/UC-02 · Κρυπτογράφηση και αποκρυπτογράφηση κειμένου με κωδικό (AES-256)")
    void tc01TextRoundTrip() throws CryptoException {
        AesCipher aes = new AesCipher();
        String cipherText = aes.encrypt("Καλημέρα κόσμε", "Κωδικός-2026");
        assertNotEquals("Καλημέρα κόσμε", cipherText);
        assertEquals("Καλημέρα κόσμε", aes.decrypt(cipherText, "Κωδικός-2026"));
    }
}
