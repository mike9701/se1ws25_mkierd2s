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
