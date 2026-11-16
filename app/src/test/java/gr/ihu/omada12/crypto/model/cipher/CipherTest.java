package gr.ihu.omada12.crypto.model.cipher;

import gr.ihu.omada12.crypto.model.key.KeyManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// Υλοποιεί: ENC-01, ENC-02, ENC-08, APP-04 (έλεγχος Caesar/Vigenère και AES με κλειδί)

/**
 * Tests των αλγορίθμων κειμένου. Η αρίθμηση TC είναι αυτή του docs/P2/2.4-test-cases.md
 * (TC-06 Caesar, TC-07 Vigenère, TC-08 κενό κείμενο, TC-10 μη έγκυρο κλειδί, TC-15 λάθος κλειδί AES).
 */
class CipherTest {

    @Test // TC-06: «HELLO» με κλειδί 3 → «KHOOR»
    void caesarShiftsByThree() throws CryptoException {
        assertEquals("KHOOR", new CaesarCipher().encrypt("HELLO", "3"));
    }

    @Test // TC-06: η αποκρυπτογράφηση επιστρέφει το αρχικό, στίξη και πεζά μένουν
    void caesarDecryptReversesEncrypt() throws CryptoException {
        CaesarCipher caesar = new CaesarCipher();
        assertEquals("Hello, World!", caesar.decrypt(caesar.encrypt("Hello, World!", "7"), "7"));
    }

    @Test // TC-07: κλασικό παράδειγμα Vigenère
    void vigenereClassicExample() throws CryptoException {
        assertEquals("LXFOPVEFRNHR", new VigenereCipher().encrypt("ATTACKATDAWN", "LEMON"));
    }

    @Test // TC-07: πεζά/κεφαλαία και μη γράμματα
    void vigenereKeepsNonLettersAndCase() throws CryptoException {
        VigenereCipher v = new VigenereCipher();
        String c = v.encrypt("Attack at dawn!", "lemon");
        assertEquals("Lxfopv ef rnhr!", c);
        assertEquals("Attack at dawn!", v.decrypt(c, "lemon"));
    }

    @Test // TC-15 (UC-02, ροή 6a1): AES με λάθος κλειδί αποτυγχάνει αντί να βγάλει «σκουπίδι»
    void aesRejectsWrongKey() throws CryptoException {
        KeyManager keys = new KeyManager();
        AesKeyCipher aes = new AesKeyCipher();
        String cipherText = aes.encrypt("μυστικό μήνυμα", keys.generateAesKey());
        CryptoException e = assertThrows(CryptoException.class, () -> aes.decrypt(cipherText, keys.generateAesKey()));
        assertEquals("error.wrongKeyOrCorrupted", e.getMessageKey());
    }

    @Test // TC-08 (UC-01, ροή 5a1): κενό κείμενο
    void emptyTextIsRejected() {
        CryptoException e = assertThrows(CryptoException.class, () -> new CaesarCipher().encrypt("", "3"));
        assertEquals("error.emptyText", e.getMessageKey());
    }

    @Test // TC-10 (UC-01, ροή 5a3): κλειδί Caesar εκτός 1–25 ή όχι αριθμός
    void caesarKeyOutOfRangeIsRejected() {
        CaesarCipher caesar = new CaesarCipher();
        CryptoException e = assertThrows(CryptoException.class, () -> caesar.validateKey("26"));
        assertEquals("error.caesarRange", e.getMessageKey());
        assertEquals("error.caesarRange",
                assertThrows(CryptoException.class, () -> caesar.validateKey("0")).getMessageKey());
        assertEquals("error.caesarNotNumber",
                assertThrows(CryptoException.class, () -> caesar.validateKey("abc")).getMessageKey());
    }

    @Test // TC-10: κλειδί Vigenère μόνο με λατινικά γράμματα
    void vigenereRejectsNonLatinKey() {
        CryptoException e = assertThrows(CryptoException.class, () -> new VigenereCipher().validateKey("κλειδί"));
        assertEquals("error.vigenereKey", e.getMessageKey());
    }
}
