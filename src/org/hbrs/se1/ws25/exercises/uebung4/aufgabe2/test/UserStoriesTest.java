package org.hbrs.se1.ws25.exercises.uebung4.aufgabe2.test;

import org.hbrs.se1.ws25.exercises.uebung4.aufgabe2.model.*;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserStoriesTest {
    private Container container;

    @BeforeEach
    void setup() {
        container = Container.getInstance();
        container.deleteAllUserStories(); // sicherstellen, dass keine alten Daten im Speicher sind
    }

    @Test
    void testValidUserStoryCreation() {
        UserStory us = new UserStory(1, "Raumreservierung", "Raum kann gebucht werden", "HBRS", 8, 2, 4, 1);
        assertEquals(1, us.getID());
        assertEquals("HBRS", us.getProject());
        assertTrue(us.getPriority() > 0);
    }

    @Test
    void testInvalidNegativeValues() {
        assertThrows(IllegalArgumentException.class, () ->
                new UserStory(2, "Test", "Negativwert prüfen", "HBRS", -1, 2, 3, 1));
    }

    @Test
    void testPriorityCalculation() {
        // Formel: (Mehrwert + Strafe) / (Aufwand + Risiko)
        UserStory us = new UserStory(3, "Berechnung", "Prüfe Gloger-Formel", "HBRS", 8, 4, 4, 2);
        double expected = (8.0 + 4.0) / (4.0 + 2.0);
        assertEquals(expected, us.getPriority(), 0.0001);
    }

    @Test
    void testAddUserStory() throws ContainerException {
        UserStory us = new UserStory(1, "Geräteausleihe", "Gerät kann gebucht werden", "HBRS", 5, 3, 2, 1);
        container.addUserStory(us);
        assertEquals(1, container.size());
    }

    @Test
    void testAddDuplicateIdThrowsException() throws ContainerException {
        UserStory us1 = new UserStory(1, "Story1", "Test", "HBRS", 5, 3, 2, 1);
        UserStory us2 = new UserStory(1, "Story2", "Test", "HBRS", 6, 2, 3, 1);
        container.addUserStory(us1);
        assertThrows(ContainerException.class, () -> container.addUserStory(us2));
    }

    @Test
    void testDeleteUserStory() throws ContainerException {
        UserStory us = new UserStory(5, "TestDelete", "löschen", "HBRS", 2, 1, 1, 1);
        container.addUserStory(us);

        String result = container.deleteUserStory(5);
        assertEquals("UserStory mit ID 5 wurde gelöscht.", result);
        assertEquals(0, container.size());
    }

    @Test
    void testDeleteNonExistingUserStory() {
        String result = container.deleteUserStory(999);
        assertEquals("UserStory mit ID 999 nicht gefunden.", result);
    }

    @Test
    void testGetCurrentListIsUnmodifiable() throws ContainerException {
        UserStory us = new UserStory(6, "Unmodifizierbare Liste", "Test", "HBRS", 3, 3, 1, 1);
        container.addUserStory(us);

        List<UserStory> list = container.getCurrentAllUserStories();
        assertThrows(UnsupportedOperationException.class, () -> list.add(us));
    }

    @Test
    void testStoreAndLoad() throws Exception {
        // Speicherstrategie setzen
        var strategy = new org.hbrs.se1.ws25.exercises.uebung3.persistence.PersistenceStrategyStream<UserStory>();
        strategy.setLocation("test_userstories.ser");
        container.setPersistenceStrategy(strategy);

        // Daten speichern
        UserStory us = new UserStory(10, "Persistenztest", "Prüfen", "HBRS", 5, 2, 2, 1);
        container.addUserStory(us);
        container.store();

        // Container leeren und wieder laden
        container.deleteAllUserStories();
        assertEquals(0, container.size());
        container.load();

        assertEquals(1, container.size());
        assertEquals(10, container.getCurrentAllUserStories().get(0).getID());
    }
}
