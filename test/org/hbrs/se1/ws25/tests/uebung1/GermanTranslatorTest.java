package org.hbrs.se1.ws25.tests.uebung1;

import org.hbrs.se1.ws25.exercises.uebung1.control.GermanTranslator;
import org.hbrs.se1.ws25.exercises.uebung1.control.Translator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GermanTranslatorTest {

    Translator translator = new GermanTranslator();

    // Positivtests (gültige Äquivalenzklasse 1–10)
    @Test
    void testValidNumbers() {
        assertEquals("eins", translator.translateNumber(1));
        assertEquals("zwei", translator.translateNumber(2));
        assertEquals("zehn", translator.translateNumber(10));
    }

    // Negativtests (ungültige Eingaben: <1)
    @Test
    void testTooSmallNumber() {
        assertEquals("Übersetzung der Zahl -3 nicht möglich (1.0)", translator.translateNumber(-3));
        assertEquals("Übersetzung der Zahl -5 nicht möglich (1.0)", translator.translateNumber(-5));
    }

    // Negativtests (ungültige Eingaben: >10)
    @Test
    void testTooLargeNumber() {
        assertEquals("Übersetzung der Zahl 15 nicht möglich (1.0)", translator.translateNumber(15));
        assertEquals("Übersetzung der Zahl 100 nicht möglich (1.0)", translator.translateNumber(100));
    }
}