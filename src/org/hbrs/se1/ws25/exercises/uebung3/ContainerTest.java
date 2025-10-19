package org.hbrs.se1.ws25.exercises.uebung3;

import org.hbrs.se1.ws25.exercises.uebung2.ContainerException;
import org.hbrs.se1.ws25.exercises.uebung3.persistence.*;
import org.hbrs.se1.ws25.exercises.uebung2.Member;

import org.junit.jupiter.api.*;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ContainerTest {

    private Container container;

    @BeforeEach
    void setup() {
        container = Container.getInstance();
        container.deleteAllMembers();
    }

    // --------------------------------------------------------------
    @Test
    @DisplayName("Test 1: Keine Strategie gesetzt")
    void testNoStrategySet() {
        container.setPersistenceStrategy(null);

        PersistenceException ex = assertThrows(
                PersistenceException.class,
                () -> container.store()
        );

        assertEquals(PersistenceException.ExceptionType.NoStrategyIsSet, ex.getExceptionTypeType());
    }

    // --------------------------------------------------------------
    @Test
    @DisplayName("Test 2: Verwendung der MongoDB-Strategie (nicht implementiert)")
    void testMongoStrategyNotAvailable() {
        PersistenceStrategy<Member> mongoStrategy = new PersistenceStrategyMongoDB<>();

        container.setPersistenceStrategy(mongoStrategy);

        assertThrows(UnsupportedOperationException.class, () -> container.store());
    }

    // --------------------------------------------------------------
    @Test
    @DisplayName("Test 3: Fehlerhafte Location (Directory statt Datei)")
    void testInvalidFileLocation() throws ContainerException {
        // Strategie auf Stream setzen
        PersistenceStrategyStream<Member> streamStrategy = new PersistenceStrategyStream<>();
        streamStrategy.setLocation("./"); // das ist ein Verzeichnis, kein Datei-Pfad
        container.setPersistenceStrategy(streamStrategy);

        // Container vorbereiten
        container.deleteAllMembers();
        container.addMember(new ConcreteMember(1));

        // Erwartet: PersistenceException vom Typ ConnectionNotAvailable
        PersistenceException ex = assertThrows(
                PersistenceException.class,
                () -> container.store()
        );

        assertEquals(
                PersistenceException.ExceptionType.ConnectionNotAvailable,
                ex.getExceptionTypeType()
        );
    }

    @Test
    @DisplayName("Test 4: Round-Trip-Test (store → clear → load)")
    void testRoundTrip() throws Exception {
        // Speicherort (temporäre Datei)
        String filePath = "members_test.ser";
        File file = new File(filePath);

        // Stream-Strategie einrichten
        PersistenceStrategyStream<Member> streamStrategy = new PersistenceStrategyStream<>();
        streamStrategy.setLocation(filePath);
        container.setPersistenceStrategy(streamStrategy);

        // Container leeren und vorbereiten
        container.deleteAllMembers();
        container.addMember(new ConcreteMember(1));
        container.addMember(new ConcreteMember(2));

        // === 1. Speichern ===
        container.store();
        assertEquals(2, container.size(), "Vor dem Löschen: Container sollte 2 Member enthalten");
        System.out.println("Aktuelle Containergröße nach dem store und vor dem löschen: " + container.size());

        // === 2. Löschen ===
        container.deleteAllMembers();
        assertEquals(0, container.size(), "Nach deleteAllMembers(): Container sollte leer sein");
        System.out.println("Aktuelle Containergröße nach dem deleteAllMembers: " + container.size());

        // === 3. Laden ===
        container.load();
        assertEquals(2, container.size(), "Nach load(): Container sollte wieder 2 Member enthalten");
        System.out.println("Aktuelle Containergröße nach dem load: " + container.size());

        // === 4. Prüfen der geladenen IDs ===
        List<Member> members = container.getCurrentList();
        assertEquals(1, members.get(0).getID());
        System.out.println("Member1 ID (sollte 1 sein): "  + members.get(0).getID());
        assertEquals(2, members.get(1).getID());
        System.out.println("Member2 ID (sollte 2 sein): " + members.get(1).getID());

        // === 5. Aufräumen ===
        boolean deleted = file.delete();
        assertTrue(deleted, "Testdatei sollte am Ende gelöscht werden");
        System.out.println("Temporäre .ser gelöscht: " + deleted);
        assertFalse(file.exists(), "Datei sollte nach delete() nicht mehr existieren");
    }
}
