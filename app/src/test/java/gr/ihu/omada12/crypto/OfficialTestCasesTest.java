package gr.ihu.omada12.crypto;

import gr.ihu.omada12.crypto.model.cipher.AesCipher;
import gr.ihu.omada12.crypto.model.cipher.CryptoException;
import gr.ihu.omada12.crypto.model.file.FileCryptoService;
import gr.ihu.omada12.crypto.model.io.ProgressListener;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Τα 5 προτεινόμενα «επίσημα» test cases του Παραδοτέου 2 (βλ. SXEDIASH.md, ενότητα δ).
 * Κάθε μέθοδος = μία γραμμή του πίνακα Test Case # · Description · Test Data · Expected Result.
 */
class OfficialTestCasesTest {

    @TempDir
    Path dir;

    @Test
    @DisplayName("TC-01 · UC-01/UC-02 · Κρυπτογράφηση και αποκρυπτογράφηση κειμένου με κωδικό (AES-256)")
    void tc01TextRoundTrip() throws CryptoException {
        AesCipher aes = new AesCipher();
        String cipherText = aes.encrypt("Καλημέρα κόσμε", "Κωδικός-2026");
        assertNotEquals("Καλημέρα κόσμε", cipherText);
        assertEquals("Καλημέρα κόσμε", aes.decrypt(cipherText, "Κωδικός-2026"));
    }

    @Test
    @DisplayName("TC-02 · UC-04 εναλλακτική ροή · Λάθος κωδικός σε αρχείο .enc: μήνυμα και κανένα αρχείο εξόδου")
    void tc02WrongPasswordCreatesNoFile() throws Exception {
        FileCryptoService service = new FileCryptoService();
        Path pdf = Files.write(dir.resolve("report.pdf"), new byte[50_000]);
        Path enc = dir.resolve("report.pdf.enc");
        service.encrypt(pdf, enc, "Σωστός-1".toCharArray(), ProgressListener.NONE);
        Path out = dir.resolve("out.pdf");
        CryptoException e = assertThrows(CryptoException.class,
                () -> service.decrypt(enc, out, "Λάθος-2".toCharArray(), ProgressListener.NONE));
        assertEquals("error.wrongKeyOrCorrupted", e.getMessageKey());
        assertFalse(Files.exists(out));
    }
}
