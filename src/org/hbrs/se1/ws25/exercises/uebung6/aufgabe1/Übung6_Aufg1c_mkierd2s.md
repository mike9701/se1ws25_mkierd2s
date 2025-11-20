# User Stories für den Use Case „Projekt auf Basis von Skills planen“

---

## User Story 1 – Skills für ein neues Projekt definieren

**Als** Unternehmer  
**möchte ich** beim Anlegen eines Projekts die benötigten Skills und deren Skill-Level festlegen,  
**damit** das System später passende Studierende zielgerichtet vorschlagen kann.

### Akzeptanzkriterien
- Der Unternehmer kann Skills auswählen oder neue Skills definieren.
- Zu jedem Skill kann ein Level (z. B. Anfänger, Mittel, Experte) hinterlegt werden.
- Die definierten Skills werden dem Projekt eindeutig zugeordnet.
- Ungültige oder fehlende Eingaben werden durch das System erkannt und gemeldet.

---

## User Story 2 – Skill-Profile von Studierenden filtern

**Als** Unternehmer  
**möchte ich** Skill-Profile von Studierenden nach bestimmten Kriterien filtern können,  
**damit** ich diejenigen finde, die am besten für das Projekt geeignet sind.

### Akzeptanzkriterien
- Filterbar nach Skill, Skill-Level und Verfügbarkeit.
- Die Ergebnisliste enthält nur Studierende, die die gewählten Skills erfüllen.
- Die Liste ist sortierbar (z. B. nach Matching, Skill-Level).

---

## User Story 3 – Automatische Matching-Empfehlung erhalten

**Als** Unternehmer  
**möchte ich** automatisch generierte Kandidatenempfehlungen basierend auf Skill-Matching erhalten,  
**damit** ich schnell ein geeignetes Team zusammenstellen kann.

### Akzeptanzkriterien
- System berechnet einen Matching-Score pro Kandidat.
- Die Ergebnisse werden nach der höchsten Übereinstimmung sortiert angezeigt.
- Skill-Übereinstimmungen und Skill-Gaps werden pro Kandidat angezeigt.

---

## User Story 4 – Skill-Gaps im geplanten Team erkennen

**Als** Unternehmer  
**möchte ich** erkennen, welche benötigten Skills im geplanten Team noch fehlen,  
**damit** ich gezielt nach weiteren geeigneten Studierenden suchen kann.

### Akzeptanzkriterien
- Darstellung der Skills, die bereits durch das Team abgedeckt sind.
- Hervorhebung der Skills, die aktuell fehlen (z. B. farblich).
- System schlägt Studierende vor, die die fehlenden Skills besitzen.

---

## User Story 5 – Teamkonfiguration speichern und wieder laden

**Als** Unternehmer  
**möchte ich** eine Zwischenversion der Teamplanung speichern können,  
**damit** ich die Planung später fortsetzen kann, ohne erneut beginnen zu müssen.

### Akzeptanzkriterien
- Das System speichert die aktuelle Skill-Anforderungsliste und alle gewählten Studierenden.
- Gespeicherte Teamkonfigurationen können wieder geladen werden.
- Zeitstempel oder Versionen sind sichtbar.

---

# Definition of Ready (DoR)

Eine User Story gilt als „ready“, wenn alle folgenden Kriterien erfüllt sind:

1. **Verständlich:**  
   Die Story ist klar formuliert (Als–möchte ich–damit) und für das gesamte Team verständlich.

2. **Akzeptanzkriterien vorhanden:**  
   Die Abnahmekriterien sind eindeutig und testbar.

3. **Unabhängig (INVEST – Independent):**  
   Die Story kann alleine umgesetzt werden oder Abhängigkeiten sind klar benannt.

4. **Schätzbar (INVEST – Estimable):**  
   Das Team kann eine Aufwandsabschätzung abgeben.

5. **Klein genug (INVEST – Small):**  
   Die Story ist innerhalb eines Sprints umsetzbar (z. B. max. 2–3 Tage).

6. **Fachliche Klarheit:**
    - Skills, Skill-Level, Matching-Kriterien sind beschrieben.
    - Unklare Fachbegriffe sind geklärt.

7. **Technische Klarheit:**
    - Alle technischen Abhängigkeiten sind geklärt.
    - Datenquellen und benötigte Services stehen zur Verfügung.

8. **PO-Akzeptanz:**  
   Die Story ist priorisiert und vom Product Owner freigegeben.