package org.hbrs.se1.ws25.exercises.uebung4.aufgabe2.view;

import org.hbrs.se1.ws25.exercises.uebung4.aufgabe2.model.UserStory;

import java.util.List;

/**
 * Zuständig für die Darstellung (View) der UserStories.
 * Sie greift nur lesend auf das Model (Container) zu.
 */
public class UserStoryView {

    /**
     * Gibt alle UserStories sortiert nach Priorität (absteigend) auf der Konsole aus.
     */
    public void dumpSortedByPriority(List<UserStory> userstories) {
        if (userstories == null || userstories.isEmpty()) {
            System.out.println("Keine User Stories vorhanden.");
            return;
        }

        userstories.stream()
                .sorted((u1, u2) -> Double.compare(u2.getPriority(), u1.getPriority()))
                .map(UserStory::toString)
                .forEach(System.out::println); // direkt ausgeben
    }

    /**
     * Gibt alle UserStories aus, die zu einem bestimmten Projekt gehören.
     */
    public void dumpByProject(List<UserStory> userstories, String projectName) {
        if (userstories == null || userstories.isEmpty()) {
            System.out.println("Keine User Stories vorhanden.");
            return;
        }

        var matches = userstories.stream()
                .filter(us -> us.getProject() != null)
                .filter(us -> us.getProject().equalsIgnoreCase(projectName))
                .toList(); // Ergebnis in eine temporäre Liste speichern

        if (matches.isEmpty()) {
            System.out.println("Keine User Stories vorhanden.");
            return;
        }

        matches.stream()
                .map(UserStory::toString)
                .forEach(System.out::println);
    }
}