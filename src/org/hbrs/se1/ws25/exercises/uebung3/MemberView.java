package org.hbrs.se1.ws25.exercises.uebung3;

import org.hbrs.se1.ws25.exercises.uebung2.Member;
import java.util.List;

public class MemberView {
    public static void dump(List<Member> liste) {
        if (liste == null || liste.isEmpty()) {
            System.out.println("(Keine Member vorhanden)");
        } else {
            System.out.println("=== Aktueller Inhalt des Containers ===");
            for (Member m : liste) {
                System.out.println(m.toString());
            }
        }
    }
}
