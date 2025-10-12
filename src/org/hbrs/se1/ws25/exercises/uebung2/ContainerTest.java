package org.hbrs.se1.ws25.exercises.uebung2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContainerTest {
    private Container container;
    private Member m1;
    private Member m2;

    @BeforeEach
    void setUp() {
        container = new Container();
        m1 = new ConcreteMember(1);
        m2 = new ConcreteMember(2);
    }

    // Container ist zu Beginn leer
    @Test
    void test1_InitialSizeIsZero() {
        assertEquals(0, container.size(), "Container sollte anfangs leer sein.");
    }

    // Nach Hinzufügen eines Members ist size = 1
    @Test
    void test2_AddOneMemberIncreasesSizeToOne() throws ContainerException {
        container.addMember(m1);
        assertEquals(1, container.size(), "Nach dem Hinzufügen eines Members sollte die Größe 1 sein.");
    }

    // Nach Hinzufügen von zwei verschiedenen Membern ist size = 2
    @Test
    void test3_AddTwoMembersIncreasesSizeToTwo() throws ContainerException {
        container.addMember(m1);
        container.addMember(m2);
        assertEquals(2, container.size(), "Nach dem Hinzufügen von zwei Membern sollte die Größe 2 sein.");
    }

    // Hinzufügen eines Members mit gleicher ID wirft Exception
    @Test
    void test4_AddingDuplicateMemberThrowsException() throws ContainerException {
        container.addMember(m1);
        container.addMember(m2);
        ContainerException ex = assertThrows(ContainerException.class, () -> container.addMember(m2));
        assertEquals("Das Member-Objekt mit der ID 2 ist bereits vorhanden!", ex.getMessage());
    }

    // Löschen eines existierenden Members verringert Größe
    @Test
    void test5_DeleteExistingMemberDecreasesSize() throws ContainerException {
        container.addMember(m1);
        container.addMember(m2);
        container.deleteMember(1);
        assertEquals(1, container.size(), "Nach dem Löschen sollte die Größe 1 sein.");
    }

    // Hinzufügen von zwei Members und anschließendes Löschen beider Member -> size = 0
    @Test
    void test6_DeleteExistingMemberDecreasesSizeToZero() throws ContainerException {
        container.addMember(m1);
        container.addMember(m2);
        container.deleteMember(1);
        container.deleteMember(2);
        assertEquals(0, container.size(), "Container sollte nach zwei mal Hinzufügen und zwei mal löschen (der selben Member) wieder 0 sein.");
    }

    // dump() verändert die Größe des Containers nicht
    @Test
    void test7_DumpDoesNotChangeSize() throws ContainerException {
        container.addMember(m1);
        container.addMember(m2);

        int sizeBefore = container.size();

        container.dump(); // sollte nur ausgeben, aber nichts verändern

        int sizeAfter = container.size();

        assertEquals(sizeBefore, sizeAfter, "Die Größe des Containers darf sich durch dump() nicht verändern.");
    }

    // toString() verändert die Größe des Containers nicht
    @Test
    void test8_ToStringDoesNotChangeSize() throws ContainerException {
        container.addMember(m1);
        container.addMember(m2);

        int sizeBefore = container.size();

        // Aufruf von toString() auf den Member-Objekten
        String s1 = m1.toString();
        String s2 = m2.toString();

        int sizeAfter = container.size();

        assertEquals(sizeBefore, sizeAfter, "Die Größe des Containers darf sich durch toString() nicht verändern.");
    }

    // Löschen eines nicht vorhandenen Members gibt Fehlermeldung zurück
    @Test
    void test9_DeleteNonExistingMemberReturnsErrorMessage() throws ContainerException {
        container.addMember(m1);
        container.addMember(m2);

        String result = container.deleteMember(999); // ID existiert nicht
        assertEquals("Member mit ID 999 nicht gefunden.", result, "Das Löschen eines nicht existierenden Members sollte eine Fehlermeldung zurückgeben.");
    }

    // Hinzufügen von null sollte eine IllegalArgumentException werfen
    @Test
    void test10_AddNullMemberThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> container.addMember(null), "Das Hinzufügen eines null-Members sollte eine IllegalArgumentException auslösen.");
    }
}
