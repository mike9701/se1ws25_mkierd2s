package org.hbrs.se1.ws25.exercises.uebung4.aufgabe2.controller;

import org.hbrs.se1.ws25.exercises.uebung4.aufgabe2.model.Container;
import org.hbrs.se1.ws25.exercises.uebung4.aufgabe2.view.UserStoryView;
import org.hbrs.se1.ws25.exercises.uebung3.persistence.PersistenceStrategyStream;
import org.hbrs.se1.ws25.exercises.uebung4.aufgabe2.model.UserStory;

import java.util.Scanner;

public class InputDialog {
    private final Container container;
    private final UserStoryView view;
    private final Scanner in = new Scanner(System.in);

    public InputDialog(Container container, UserStoryView view) {
        this.container = container;
        this.view = view;

        // --- Persistence automatisch setzen ---
        var strategy = new PersistenceStrategyStream<UserStory>();
        strategy.setLocation("userstories.ser");
        container.setPersistenceStrategy(strategy);
    }

    public void run() {
        System.out.println("Willkommen. Tippe 'help' für Befehle.");
        while (true) {
            System.out.print("> ");
            String line = in.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] tokens = line.split("\\s+");
            String cmd = tokens[0].toLowerCase();

            switch (cmd) {
                case "help" -> printHelp();
                case "dump" -> handleDump(tokens);
                case "store" -> handleStore();
                case "load" -> handleLoad();
                case "enter" -> handleEnterInteractive();
                case "exit" -> { System.out.println("Bye!"); return; }
                default -> System.out.println("Unbekannter Befehl. 'help' zeigt Optionen.");
            }
        }
    }

    private void handleDump(String[] tokens) {
         // Wenn nur "dump" eingegeben wurde → nach Priorität sortiert
        if (tokens.length == 1) {
            var data = container.getCurrentAllUserStories();
            view.dumpSortedByPriority(data);
            return;
        }

        // Wenn "dump project <Name>" eingegeben wurde → gefiltert nach Projekt
        if (tokens.length >= 3 && tokens[1].equalsIgnoreCase("project")) {
            // Alles nach "project" als Projektnamen zusammensetzen
            String projectName = String.join(" ", java.util.Arrays.copyOfRange(tokens, 2, tokens.length));
            var data = container.getCurrentAllUserStories();
            view.dumpByProject(data, projectName);
            return;
        }

        // Alles andere → ungültig
        System.out.println("Unbekannter Befehl. Verwendung: 'dump' oder 'dump project <Name>'");
    }

    private void handleStore() {
        try {
            container.store();  // schreibt alle UserStories in userstories.ser
            System.out.println("User Stories gespeichert.");
        } catch (org.hbrs.se1.ws25.exercises.uebung3.persistence.PersistenceException e) {
            System.err.println("Speichern fehlgeschlagen: " + e.getMessage());
        }
    }

    private Integer readPositiveInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = in.nextLine().trim();
            try {
                int v = Integer.parseInt(s);
                if (v > 0) return v;
            } catch (NumberFormatException ignore) {}
            System.out.println("Bitte eine positive ganze Zahl eingeben.");
        }
    }

    private double readNonNegativeDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = in.nextLine().trim();
            try {
                double v = Double.parseDouble(s);
                if (v >= 0.0) return v;
            } catch (NumberFormatException ignore) {}
            System.out.println("Bitte eine Zahl >= 0 eingeben.");
        }
    }

    private String readNonEmpty(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = in.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Eingabe darf nicht leer sein.");
        }
    }

    private void handleEnterInteractive() {
        try {
            System.out.println("Interaktive Eingabe einer User Story (leer = Abbruch bei Textfeldern).");

            Integer id = readPositiveInt("ID (Integer > 0): ");
            String title = readNonEmpty("Titel: ");
            String ac = readNonEmpty("Akzeptanzkriterium: ");
            String project = readNonEmpty("Projekt: ");

            double mehrwert = readNonNegativeDouble("Mehrwert (>= 0): ");
            double strafe   = readNonNegativeDouble("Strafe (>= 0): ");
            double aufwand  = readNonNegativeDouble("Aufwand (>= 0): ");
            double risiko   = readNonNegativeDouble("Risiko (>= 0): ");

            var us = new org.hbrs.se1.ws25.exercises.uebung4.aufgabe2.model.UserStory(
                    id, title, ac, project, mehrwert, strafe, aufwand, risiko
            );

            container.addUserStory(us);
            System.out.println("User Story angelegt: " + us);

        } catch (org.hbrs.se1.ws25.exercises.uebung4.aufgabe2.model.ContainerException e) {
            System.err.println("Fehler: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            // z. B. aus UserStory-Validierung (negative Werte, ID ungültig)
            System.err.println("Eingabefehler: " + e.getMessage());
        }
    }

    private void handleLoad() {
        try {
            container.load();  // liest aus userstories.ser (Strategy ist im Konstruktor gesetzt)
            System.out.println("User Stories geladen.");
        } catch (org.hbrs.se1.ws25.exercises.uebung3.persistence.PersistenceException e) {
            System.err.println("Laden fehlgeschlagen: " + e.getMessage());
        }
    }

    private void printHelp() {
        System.out.println("""
                Befehle:
                enter             - interaktive Eingabe einer User Story
                dump              - Ausgabe aller User Stories nach Priorität (absteigend)
                dump project XYZ  - Ausgabe aller User Stories im Projekt XYZ
                store             - speichert alle User Stories persistent in userstories.ser
                load              - lädt User Stories von userstories.ser
                help              - zeigt diese Hilfe
                exit              - beendet das Programm
                """);
    }
}
