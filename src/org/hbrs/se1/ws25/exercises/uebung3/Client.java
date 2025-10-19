package org.hbrs.se1.ws25.exercises.uebung3;

import org.hbrs.se1.ws25.exercises.uebung2.Member;
import org.hbrs.se1.ws25.exercises.uebung3.persistence.PersistenceStrategy;
import org.hbrs.se1.ws25.exercises.uebung3.persistence.PersistenceStrategyStream;

public class Client {
    public static void main(String[] args) {
        //Singleton Container holen
        Container container = Container.getInstance();

        //Persistenzstrategie setzen
        PersistenceStrategyStream<Member> streamStrategy = new PersistenceStrategyStream();
        streamStrategy.setLocation("members.ser");
        container.setPersistenceStrategy(streamStrategy);

        try{
            //Member hinzufügen
            container.addMember(new ConcreteMember(1));
            container.addMember(new ConcreteMember(2));
            container.addMember(new ConcreteMember(3));

            //Ausgabe über MemberView
            MemberView.dump(container.getCurrentList());

            //Daten persistent speichern
            container.store();
            System.out.println("Member wurden erfolgreich gespeichert.");

            // Container leeren
            container.deleteAllMembers();
            System.out.println("Container nach deleteAllMembers():");
            MemberView.dump(container.getCurrentList());

            // Daten wieder laden
            container.load();
            System.out.println("Container nach load():");
            MemberView.dump(container.getCurrentList());

        } catch (Exception e) {
            System.err.println("Fehler: " + e.getMessage());
        }
    }
}
