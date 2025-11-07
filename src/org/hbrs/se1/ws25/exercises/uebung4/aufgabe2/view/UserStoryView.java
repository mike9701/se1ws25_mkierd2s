package org.hbrs.se1.ws25.exercises.uebung4.aufgabe2.view;

import org.hbrs.se1.ws25.exercises.uebung4.aufgabe2.model.UserStory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Zuständig für die Darstellung (View) der UserStories.
 * Sie greift nur lesend auf das Model (Container) zu.
 */
public class UserStoryView {

    /**
     * Gibt alle UserStories sortiert nach Priorität (absteigend) auf der Konsole aus.
     */
    public void dumpSortedByIdDesc(List<UserStory> userstories) {
        if (userstories == null || userstories.isEmpty()) {
            System.out.println("Keine User Stories vorhanden.");
            return;
        }

        // Liste der Prioritäten anlegen
        List<Double> prios = new ArrayList<>();
        for (UserStory us : userstories) {
            prios.add(us.getPriority());
        }

        // Prioritäten absteigend sortieren
        Collections.sort(prios, Collections.reverseOrder());

        // Für jede Priorität die passende UserStory ausgeben
        for (Double prio : prios) {
            for (UserStory us : userstories) {
                if (us.getPriority() == prio) {
                    System.out.println(us);
                    break; // sobald gefunden, weiter zur nächsten Prio
                }
            }
        }
    }
}