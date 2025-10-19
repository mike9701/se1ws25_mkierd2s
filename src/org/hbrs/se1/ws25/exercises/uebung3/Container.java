package org.hbrs.se1.ws25.exercises.uebung3;

import org.hbrs.se1.ws25.exercises.uebung2.ContainerException;
import org.hbrs.se1.ws25.exercises.uebung2.Member;

import java.util.ArrayList;
import java.util.List;

public class Container {
    /**
     * CR1: Singleton Pattern
     */

    // Statische Referenz auf das einzige Objekt
    private static Container instance = null;

    // Privater Konstruktor verhindert direkte Instanziierung
    private Container() {
    }

    // Öffentliche statische Zugriffsmethode
    public static Container getInstance() {
        if (instance == null) {
            instance = new Container();
        }
        return instance;
    }

    /**
     * -------------------------------------------------------------------------------------------
     */

    // interne Speicherung mit java.util.List
    private List<Member> members = new ArrayList<>();

    /**
     * FA1: Hinzufügen eines Member-Objekts.
     */
    public void addMember(Member member) throws ContainerException {
        if (member == null) {
            throw new IllegalArgumentException("Member darf nicht null sein!");
        }

        for (Member m : members) {
            if (m.getID().equals(member.getID())) {
                throw new ContainerException(member.getID());
            }
        }
        members.add(member);
    }

    /**
     * FA2: Löschen eines Member-Objekts anhand der ID.
     *
     *  Hinweis (Statement zur Aufgabenstellung):
     *  Das Fehlerhandling über Rückgabewerte hat den Nachteil, dass der Aufrufer
     *  den Rückgabewert eventuell nicht prüft und so Fehler unbemerkt bleiben.
     *  Exceptions hingegen erzwingen eine explizite Behandlung oder Weitergabe
     *  des Fehlers, wodurch der Code robuster und wartbarer wird.
     */
    public String deleteMember(Integer id) {
        for (Member m : members) {
            if (m.getID().equals(id)) {
                members.remove(m);
                return "Member mit ID " + id + " wurde gelöscht.";
            }
        }
        return "Member mit ID " + id + " nicht gefunden.";
    }

    /**
     * FA3: Ausgabe aller gespeicherten Member.
     */
    public void dump() {
        System.out.println("=== Aktueller Inhalt des Containers ===");
        for (Member m : members) {
            System.out.println(m.toString());
        }
    }

    /**
     * FA4: Rückgabe der aktuellen Größe.
     */
    public int size() {
        return members.size();
    }
}
