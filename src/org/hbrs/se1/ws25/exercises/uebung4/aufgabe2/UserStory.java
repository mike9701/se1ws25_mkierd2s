package org.hbrs.se1.ws25.exercises.uebung4.aufgabe2;

import java.io.Serializable;

/**
 * Repräsentiert eine einzelne User Story im System.
 * Hintergrund: Diese Klasse ist die zentrale Datenstruktur für das Tool.
 * Sie kapselt alle Eingaben des Entwicklers und stellt sicher,
 * dass nur gültige Daten gespeichert werden.
 */
public class UserStory implements Serializable {
    // --- Basisinformationen ---
    private final String id;                    // Eindeutige Kennung, darf nicht null sein
    private String title;                       // Kurzer Titel der User Story
    private String acceptanceCriterion;         // Einfache Beschreibung des Erfolgsfalls
    private String project;                     // Projektzuordnung

    // Gloger-Kennzahlen
    private double mehrwert; // >= 0
    private double strafe;   // >= 0
    private double aufwand;  // >= 0
    private double risiko;   // >= 0

    // --- Ergebniswert ---
    private double priority;                    // Berechneter Priorisierungswert

    public UserStory(String id, String title, String acceptanceCriterion, String project, double mehrwert, double strafe, double aufwand, double risiko) {

        //Wenn ID leer ist -> Exception werfen
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID darf nicht leer sein.");
        }

        this.id = id;
        this.title = title;
        this.acceptanceCriterion = acceptanceCriterion;
        this.project = project;

        setMehrwert(mehrwert);
        setStrafe(strafe);
        setAufwand(aufwand);
        setRisiko(risiko);
    }

    // ----------------- Getter -----------------
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAcceptanceCriterion() { return acceptanceCriterion; }
    public String getProject() { return project; }
    public double getMehrwert() { return mehrwert; }
    public double getStrafe() { return strafe; }
    public double getAufwand() { return aufwand; }
    public double getRisiko() { return risiko; }
    public double getPriority() { return priority; }

    // ----------------- Setter (mit Recalc) -----------------
    public void setTitle(String title) { this.title = title; }
    public void setAcceptanceCriterion(String ac) { this.acceptanceCriterion = ac; }
    public void setProject(String project) { this.project = project; }

    public void setMehrwert(double v) {
        validateNonNegative(v, "Mehrwert");
        this.mehrwert = v;
        recalculatePriority();
    }

    public void setStrafe(double v) {
        validateNonNegative(v, "Strafe");
        this.strafe = v;
        recalculatePriority();
    }

    public void setAufwand(double v) {
        validateNonNegative(v, "Aufwand");
        this.aufwand = v;
        recalculatePriority();
    }

    public void setRisiko(double v) {
        validateNonNegative(v, "Risiko");
        this.risiko = v;
        recalculatePriority();
    }

    /**
     * Hilfsmethode zur Eingabevalidierung.
     */
    private void validateNonNegative(double value, String name) {
        if (value < 0) {
            throw new IllegalArgumentException(name + " darf nicht negativ sein!");
        }
    }

    /**
     * Implementiert exakt die Gloger-Formel:
     * Prio = (Mehrwert + Strafe) / (Aufwand + Risiko)
     */
    private void recalculatePriority() {
        double denominator = aufwand + risiko;
        if (denominator <= 0.0) {
            throw new IllegalStateException(
                    "Aufwand + Risiko muss > 0 sein, um eine Priorität berechnen zu können."
            );
        }
        this.priority = (mehrwert + strafe) / denominator;
    }

    @Override
    public String toString() {
        return "UserStory{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", project='" + project + '\'' +
                ", mehrwert=" + mehrwert +
                ", strafe=" + strafe +
                ", aufwand=" + aufwand +
                ", risiko=" + risiko +
                ", priority=" + priority +
                '}';
    }
}
