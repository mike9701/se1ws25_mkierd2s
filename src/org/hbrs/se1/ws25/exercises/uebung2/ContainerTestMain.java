package org.hbrs.se1.ws25.exercises.uebung2;

public class ContainerTestMain {
    public static void main(String[] args) {
        Container container = new Container();

        Member m1 = new ConcreteMember(1);
        Member m2 = new ConcreteMember(2);
        Member m3 = new ConcreteMember(3);
        try {
            // Test 1: Hinzufügen von Membern
            container.addMember(m1);
            container.addMember(m2);
            System.out.println("Size nach 2 Adds: " + container.size()); // Erwartet: 2

            // Test 2: Versuch, Duplikat hinzuzufügen
            try {
                container.addMember(m1);
            } catch (ContainerException e) {
                System.out.println(e.getMessage()); // Erwartet: Exception-Text
            }

            // Test 3: Member löschen
            System.out.println(container.deleteMember(2)); // Erwartet: gelöscht
            System.out.println("Size nach Delete: " + container.size()); // Erwartet: 1

            // Test 4: Nicht vorhandenes Member löschen
            System.out.println(container.deleteMember(99)); // Erwartet: nicht gefunden

            // Test 5: Neues Member hinzufügen
            container.addMember(m3);
            System.out.println("Size nach Add m3: " + container.size()); // Erwartet: 2

            // Test 6: Dump-Ausgabe
            container.dump();

        } catch (ContainerException e) {
            e.printStackTrace();
        }

    }
}
