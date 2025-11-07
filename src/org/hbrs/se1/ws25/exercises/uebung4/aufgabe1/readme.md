# Aufgabe 1 (b): User Stories – Projekt *AllMyResources@HBRS*

## Ziel
Diese Datei enthält acht aussagekräftige **User Stories** für die geplante Hochschulsoftware *AllMyResources@HBRS*.  
Jede User Story wurde einem **Epic** zugeordnet und erfüllt die **INVEST-Kriterien** (Independent, Negotiable, Valuable, Estimable, Small, Testable).  
Zudem enthält jede Story:
- eine Mehrwertschätzung (Nutzenbewertung)
- eine Aufwandsschätzung auf Basis der Fibonacci-Zahlen
- mindestens zwei verifizierbare Akzeptanzkriterien

---

## Übersicht der Epics
1. Raumverwaltung
2. Geräteverwaltung
3. Materialverwaltung
4. Benutzerverwaltung
5. Integration / Benachrichtigungssystem

---

## User Stories

### **Epic 1: Raumverwaltung**

#### User Story 1: Raum buchen
Als Student*in möchte ich verfügbare Räume online buchen können,  
um Gruppenarbeiten und Lernphasen besser planen zu können.

- **Mehrwert:** Hoch
- **Aufwand (Fibonacci):** 5

**Akzeptanzkriterien:**
1. Studierende können Datum, Uhrzeit und Dauer einer Buchung auswählen.
2. Das System zeigt nur freie Räume im gewählten Zeitraum an.
3. Eine Bestätigung wird automatisch per E-Mail versendet.



#### User Story 2: Raumverfügbarkeit anzeigen
Als Student*in möchte ich in Echtzeit sehen, welche Räume aktuell frei sind,  
um spontan Lernplätze zu finden.

- **Mehrwert:** Mittel
- **Aufwand (Fibonacci):** 8

**Akzeptanzkriterien:**
1. Die Anzeige wird mindestens alle zwei Minuten aktualisiert.
2. Räume sind farblich nach Status (frei/belegt) markiert.
3. Die Anzeige ist auf Desktop und Mobilgeräten nutzbar.

---

### **Epic 2: Geräteverwaltung**

#### User Story 3: Geräte ausleihen
Als Student*in möchte ich Geräte (z. B. Laptops, Beamer) online reservieren können,  
um diese für Präsentationen oder Projekte zu nutzen.

- **Mehrwert:** Hoch
- **Aufwand (Fibonacci):** 5

**Akzeptanzkriterien:**
1. Studierende können Geräte nach Zeitraum und Typ suchen.
2. Reservierungen erscheinen im Nutzerkonto.
3. Überfällige Geräte werden automatisch als „rückgabeoffen“ markiert.

#### User Story 4: Defekte Geräte melden
Als Nutzer*in möchte ich Defekte an Geräten direkt im System melden,  
um die Instandhaltung zu unterstützen und andere zu informieren.

- **Mehrwert:** Mittel
- **Aufwand (Fibonacci):** 3

**Akzeptanzkriterien:**
1. Es gibt ein Formular zur Defektmeldung mit Beschreibung und optionalem Foto.
2. Meldungen werden automatisch an die Verwaltung weitergeleitet.
3. Geräte mit Defekt sind als „in Wartung“ markiert.

---

### **Epic 3: Materialverwaltung**

#### User Story 5: Lagerbestände einsehen
Als Laborassistent*in möchte ich den aktuellen Bestand an Materialien und Laborbedarf sehen,  
um rechtzeitig Nachbestellungen einleiten zu können.

- **Mehrwert:** Mittel
- **Aufwand (Fibonacci):** 5

**Akzeptanzkriterien:**
1. Materialien werden mit Menge und Standort angezeigt.
2. Niedrige Bestände werden farblich hervorgehoben.
3. Die Ansicht kann nach Materialtyp gefiltert werden.

#### User Story 6: Nachbestellung anstoßen
Als Laborassistent*in möchte ich bei niedrigem Bestand automatisch eine Nachbestellung auslösen,  
um Versorgungslücken zu vermeiden.

- **Mehrwert:** Hoch
- **Aufwand (Fibonacci):** 8

**Akzeptanzkriterien:**
1. Bei weniger als 10 % Restbestand wird eine Nachbestellung vorgeschlagen.
2. Bestellungen müssen von der Verwaltung freigegeben werden.
3. Nachbestellte Artikel erhalten den Status „in Lieferung“.

---

### **Epic 4: Benutzerverwaltung**

#### User Story 7: Rollenbasierter Zugriff
Als Administrator*in möchte ich Rollen und Berechtigungen im System verwalten,  
um sicherzustellen, dass nur autorisierte Personen auf bestimmte Funktionen zugreifen können.

- **Mehrwert:** Hoch
- **Aufwand (Fibonacci):** 8

**Akzeptanzkriterien:**
1. Rollen (Student, Mitarbeiter, Admin) sind im System definiert.
2. Jede Rolle hat nur Zugriff auf freigegebene Funktionen.
3. Änderungen an Rechten werden protokolliert.

---

### **Epic 5: Integration / Benachrichtigungssystem**

#### User Story 8: Buchungsbestätigung per E-Mail
Als Student*in möchte ich nach einer erfolgreichen Buchung eine Bestätigung per E-Mail erhalten,  
um sicherzugehen, dass meine Reservierung registriert wurde.

- **Mehrwert:** Mittel
- **Aufwand (Fibonacci):** 3

**Akzeptanzkriterien:**
1. Nach jeder Buchung wird automatisch eine Bestätigungs-E-Mail versendet.
2. Die E-Mail enthält Raum, Datum, Uhrzeit und Dauer der Buchung.
3. Eine Stornierung ist über einen Link in der E-Mail möglich.

---

## Zusammenfassung

| Nr. | Epic | User Story | Mehrwert | Aufwand (Fibonacci) |
|----:|------|-------------|-----------|----------------------|
| 1 | Raumverwaltung | Raum buchen | Hoch | 5 |
| 2 | Raumverwaltung | Raumverfügbarkeit anzeigen | Mittel | 8 |
| 3 | Geräteverwaltung | Geräte ausleihen | Hoch | 5 |
| 4 | Geräteverwaltung | Defekte Geräte melden | Mittel | 3 |
| 5 | Materialverwaltung | Lagerbestände einsehen | Mittel | 5 |
| 6 | Materialverwaltung | Nachbestellung anstoßen | Hoch | 8 |
| 7 | Benutzerverwaltung | Rollenbasierter Zugriff | Hoch | 8 |
| 8 | Integration | Buchungsbestätigung per E-Mail | Mittel | 3 |

