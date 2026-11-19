package ch.bbw.architecturerefcard01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Reiner Unit-Test (ohne Spring) fuer das Lombok-Datenobjekt Message.
 */
class MessageTest {

    @Test
    void konstruktorUndGetterFunktionieren() {
        Message message = new Message("Hallo");
        assertEquals("Hallo", message.getText());
    }

    @Test
    void setterUeberschreibtText() {
        Message message = new Message();
        assertNull(message.getText());
        message.setText("Neu");
        assertEquals("Neu", message.getText());
    }

    @Test
    void equalsVergleichtInhalt() {
        assertEquals(new Message("A"), new Message("A"));
    }
}
