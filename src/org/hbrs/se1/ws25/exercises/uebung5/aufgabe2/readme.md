# Aufgabe 2a

## 1. Bewertung der User Story nach INVEST

Gegebene User Story

> **„Als Student möchte ich mich auf Projektausschreibungen bewerben und nach diesen suchen.“**

Die INVEST-Kriterien helfen dabei zu prüfen, ob eine User Story gut formuliert ist.  
Wichtig ist hier insbesondere das Kriterium:

**S – Small (Ist die Story klein genug?)**

Die gegebene Story umfasst zwei unterschiedliche fachliche Funktionen:

1. **Projektausschreibungen suchen**
2. **Sich auf Projektausschreibungen bewerben**

Diese Funktionen:

- haben unterschiedliche Ziele,
- betreffen unterschiedliche Systemprozesse,
- benötigen unterschiedliche fachliche Voraussetzungen  
  (z. B. vollständige Stammdaten für die Bewerbung).

**Fazit:**  
Die User Story ist **nicht „Small“**.  
Sie beschreibt zwei unabhängige Use Cases und muss aufgeteilt werden.

---

## 2. Verbesserung der User Story / Aufteilung

**User Story 1: Projektausschreibungen suchen**

> **Als Student möchte ich nach Projektausschreibungen suchen, damit ich passende Projektangebote finden kann.**

**Akzeptanzkriterien**
1. Der Student kann Suchbegriffe eingeben, und die Liste der Projektausschreibungen wird entsprechend gefiltert.
2. Der Student kann nach Kategorien oder Skills filtern.
3. Das System zeigt zu jeder Ausschreibung mindestens Titel, Kurzbeschreibung und Unternehmer an.

**User Story 2: Auf Projektausschreibungen bewerben**

> **Als Student möchte ich mich auf eine ausgewählte Projektausschreibung bewerben, damit ich als Kandidat berücksichtigt werde.**

**Akzeptanzkriterien**
1. Der Student kann eine konkrete Projektausschreibung auswählen und eine Bewerbung abschicken.
2. Das System prüft, ob die Stammdaten des Studenten vollständig und gültig sind.
3. Nach erfolgreicher Bewerbung erhält der Student eine Bestätigung.

---

## Zusammenfassung
- Die ursprüngliche Story war **nicht ausreichend klein** („S“ aus INVEST nicht erfüllt).
- Durch die Aufteilung in zwei kleinere Stories wird das Kriterium erfüllt.
- Die neuen Stories enthalten **klare, testbare Akzeptanzkriterien**, wodurch auch das Kriterium **T – Testable** erfüllt ist.

---

---

---

# Aufgabe 2b <u>(Siehe auch Diagramm, <font color="green">GRÜNE</font> Änderungen)</u>

## 1. Einfluss der Student-User-Stories

Aus 2a sind zwei neue User Stories entstanden:

1. **US_1: Projektausschreibungen suchen**
2. **US_2: Auf Projektausschreibungen bewerben**

Diese Stories lassen sich wie folgt auf das bestehende Use-Case-Modell aus Aufgabe 5-1 abbilden:

**Neuer Use Case: „Projektausschreibungen suchen"**

- **Akteur:** Student
- **Neuer Use Case:** `Projektausschreibungen suchen`
- Dieser Use Case ist **nicht** durch einen bestehenden Use Case abgedeckt.  
  Bisher konnte nur der Unternehmer über `Skills suchen` nach passenden Studenten suchen.
- Im erweiterten Use-Case-Modell wird daher ein **neuer Use Case** für den Studenten ergänzt, der die Suche nach offenen Projektausschreibungen modelliert.

**Neuer Use Case: „Auf Projektausschreibung bewerben“**

- **Akteur:** Student
- **Neuer Use Case:** `Auf Projektausschreibung bewerben` (oder „Bewerbung auf Projektausschreibung abgeben“)
- Inhaltlich ist dieser Use Case komplementär zu `Bewerbungen verwalten` auf Unternehmerseite:
    - Der Student initiiert eine Bewerbung,
    - der Unternehmer verwaltet die eingegangenen Bewerbungen.
- Da im Text gefordert ist, dass Stammdaten eine Rolle spielen, kann der neue Use Case zusätzlich den bestehenden Use Case `Studentische Stammdaten verwalten` mittels `<<include>>` verwenden, z. B. um vor dem Absenden der Bewerbung zu prüfen, ob die Stammdaten vollständig/gültig sind.

**Folge:**  
Das Use-Case-Modell wird um **zwei neue Student-Use-Cases** erweitert.  
Alle übrigen bestehenden Use Cases bleiben unverändert, werden aber durch die neuen Fälle funktional ergänzt.

## 2. Einfluss der Unternehmer-User-Story zur Inhaltsangabe

Zusätzliche User Story:

> „Als Unternehmer möchte ich bei der Aufgabe einer Projektausschreibung eine Inhaltsangabe des Projekts hinzufügen, damit der potenzielle Student eine bessere Vorstellung seiner zukünftigen Tätigkeit hat.“

Diese Story bezieht sich klar auf den bereits existierenden Use Case:

- `Projektausschreibung aufgeben` (Akteur: Unternehmer)

Inhaltlich beschreibt sie **einen zusätzlichen fachlichen Schritt innerhalb dieses bestehenden Use Cases**:

- Beim Anlegen der Projektausschreibung soll eine **Inhaltsangabe / Kurzbeschreibung** des Projekts erfasst werden, damit Studierende das Projekt besser einschätzen können.

**Begründete Entscheidung:**  
In Anlehnung an die Vorlesungsfolie („Keine übermäßige funktionale Decomposition – weniger ist manchmal mehr“) wird hier auf einen weiteren Use-Case verzichtet:  
Die User Story führt zu einer **fachlichen Verfeinerung des bestehenden Use Cases `Projektausschreibung aufgeben`**, aber **nicht zu einem eigenen neuen Use Case** im Diagramm.

---

---

---

# Aufgabe 2c

## Textueller Use Case: „Auf Projektausschreibung bewerben“

**System:** Coll@HBRS  
**Use Case Name:** Auf Projektausschreibung bewerben  
**Akteur:** Student  
**Ziel:** Der Student möchte sich erfolgreich auf eine ausgewählte Projektausschreibung bewerben.

## Vorbedingungen

1. Der Student ist im System **eingeloggt**.
2. Der Student hat eine **konkrete Projektausschreibung** geöffnet.

## Ereignisfluss (Normalfall)

1. Das System zeigt die Detailansicht der Projektausschreibung an.
2. Der Student klickt auf **„Jetzt bewerben“**.
3. Das System öffnet das Bewerbungsformular.
4. Der Student gibt alle benötigten Angaben ein (z. B. Motivationsfeld, optionale Kommentare).
5. Das System prüft automatisch die **Vollständigkeit und Gültigkeit der Stammdaten**.
6. Das System zeigt dem Studenten eine **Übersicht zur finalen Bestätigung** an.
7. Der Student klickt auf **„Bewerbung abschicken“**.
8. Das System speichert die Bewerbung und ordnet sie der entsprechenden Projektausschreibung zu.
9. Das System bestätigt: *„Ihre Bewerbung wurde erfolgreich versendet.“*

## Alternativer Ereignisfluss (Fehlerfall)

**A1 – Stammdaten ungültig oder unvollständig**

5a. Das System erkennt fehlerhafte oder fehlende Stammdaten (z. B. kein Geburtsdatum).  
5b. Das System zeigt eine Fehlermeldung:  
*„Ihre Stammdaten sind unvollständig. Bitte aktualisieren Sie Ihr Profil.“*  
5c. Das System verweist den Studenten zur Profilaktualisierung.  
5d. Der Use Case endet ohne Bewerbung.

## Nachbedingungen

1. Die Bewerbung ist dauerhaft im System gespeichert.
2. Die Bewerbung ist für den Unternehmer im Use Case **„Bewerbungen verwalten“** sichtbar.
3. Der Student hat eine Bestätigung erhalten.

## Test Case (Positivtest)

**Test Case Name:** TC-01 – Erfolgreiche Bewerbung  
**Ziel:** Überprüfung, dass die Bewerbung korrekt gespeichert und bestätigt wird.  
**Voraussetzung:** Student ist eingeloggt und steht auf der Detailansicht einer Projektausschreibung.

## Test Input / Annahmen

- Motivationsfeld: „Ich interessiere mich sehr für das Projekt.“
- Button: **„Jetzt bewerben“**
- Button: **„Bewerbung abschicken“**
- Stammdaten sind vollständig:
  - Name: „Max Beispiel“
  - Geburtsdatum: „01.01.2000“
  - Matrikelnummer: „1234567“

## Testschritte

| Schritt | Aktion | Erwartetes Ergebnis |
|--------|--------|----------------------|
| 1 | Klick auf „Jetzt bewerben“ | System öffnet Bewerbungsformular |
| 2 | Student füllt das Motivationsfeld aus | Text erscheint korrekt im Eingabefeld |
| 3 | System prüft Stammdaten | System bestätigt: Stammdaten gültig |
| 4 | Klick auf „Bewerbung abschicken“ | Bewerbung wird gespeichert |
| 5 | Systemmeldung anzeigen | *„Ihre Bewerbung wurde erfolgreich versendet.“* |

## Überprüfung der Nachbedingung

- Bewerbung erscheint unter **„Meine Bewerbungen“** im Studentenprofil.
- Unternehmer sieht die Bewerbung in **„Bewerbungen verwalten“**.

**Der Test ist erfolgreich**, wenn beide Nachbedingungen erfüllt sind.