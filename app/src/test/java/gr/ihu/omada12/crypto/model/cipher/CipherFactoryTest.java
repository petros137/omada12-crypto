package gr.ihu.omada12.crypto.model.cipher;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// Υλοποιεί: ENC-01, NFR-11 (έλεγχος του Factory αλγορίθμων)

/** TC-26: κάθε όνομα της λίστας δίνει τον σωστό αλγόριθμο· άγνωστο όνομα απορρίπτεται. */
class CipherFactoryTest {

    @Test
    void everyListedAlgorithmCanBeCreated() {
        for (String name : CipherFactory.availableAlgorithms()) {
            assertEquals(name, CipherFactory.create(name).getName());
        }
    }

    @Test
    void listHasTheFourAlgorithmsOfUi02() {
        assertEquals(4, CipherFactory.availableAlgorithms().size());
    }

    @Test
    void unknownAlgorithmIsRejected() {
        assertThrows(IllegalArgumentException.class, () -> CipherFactory.create("ROT13"));
    }
}
