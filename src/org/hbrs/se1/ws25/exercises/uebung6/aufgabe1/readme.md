# Use Case: Projektausschreibung aufgeben
**System:** Coll@HBRS

---

## Akteure
**Unternehmer**, **Externes Cloud-Informationssystem**

---

## Vorbedingung

- Registrierter Unternehmer hat im System Coll@HBRS eingeloggt  
  (Use Case: „Benutzer authentifiziert sich“; die Registrierung ist im Use Case  
  „Unternehmer registriert sich“ erfolgt).
- Der Unternehmer hat auf der Startseite von Coll@HBRS die Seite zur Einstellung  
  einer Projektausschreibung angefordert, das System hat die Seite entsprechend dargestellt.

---

## Grundlegender Ereignisfluss

1. Der Unternehmer spezifiziert in einem Unterbereich dieser Unterseite die Daten für  
   seine Projektausschreibung, die ein Student erfüllen muss. Dabei bestimmt er  
   innerhalb von diesem Anwendungsfall auch die Art der Projektausschreibung.  
   Folgende Arten von Projektausschreibungen werden unterstützt: **Praxisprojekt**,  
   **Festanstellung** oder **Freelancer**.  
   Falls die Eingabe getätigt wurde, navigiert der Unternehmer zur nächsten  
   Eingabeseite. Das System zeigt die Eingabeseite an.

2. Der Unternehmer schreibt einen Beschreibungstext der Projektausschreibung  
   innerhalb dieser Eingabeseite. Falls die Eingabe fertig ist, navigiert er zur  
   nächsten Seite, die das System ihm anzeigt. Alternativ kann er zur letzten  
   Eingabeseite zurück navigieren, um dort Änderungen vorzunehmen  
   (à Rücksprung Schritt 2).

3. Der Unternehmer kann in einer Gesamtübersicht seine eingegebenen Daten lesen.  
   Er muss die Korrektheit der Daten bestätigen. Falls er Fehler in seinen  
   Beschreibungen feststellt, kann er diese in der Gesamtübersicht korrigieren.  
   Falls keine Fehler vorhanden sind, schickt er den Auftrag zur Einstellung der  
   Projektausschreibung an das System.

4. Das System empfängt die eingegebenen Daten des Auftrags für die  
   Projektausschreibung und verifiziert die Gültigkeit der Daten.  
   (**TODO Nr. 2**)

5. Das System erstellt auf Basis der korrekten Daten eine Projektausschreibung und  
   überführt die Angaben aus diesem in ein externes Informationssystem eines  
   Cloudanbieters.

6. Das System ermittelt die Bankverbindung des Unternehmers und speichert diese  
   temporär zur weiteren Verwendung (durch Einbeziehung des Use Case  
   „Bankverbindung verwalten“, vgl. **TODO Nr. 3**).

7. Das System ermittelt den Betrag für die Projektausschreibung und bucht von dem  
   Konto des Unternehmens über die Einbeziehung des Use Case „Bankeinzug  
   durchführen“ den Betrag per Bankeinzug ab. Der Unternehmer wird mit der neuen  
   Projektausschreibung assoziiert. (Alternativer Ereignisfluss unten zu  
   spezifizieren, vgl. **TODO Nr. 4**. Hinweis für die Modellierung: innerhalb des  
   Supplier Use Cases wird der Auftrag an das externe Buchungssystem  
   „Banking-Software“, welches nur mit dem Supplier Use Case assoziiert ist,  
   weitergereicht).

8. Das System schickt dem Unternehmer eine Bestätigung zurück auf eine neue  
   Ausgabeseite, dass die Projektausschreibung erfolgreich eingestellt werden  
   konnte. Die Bestätigung enthält außerdem eine Mitteilung, dass das System den  
   Betrag erfolgreich abbuchen konnte.

---

## TODO 2: Alternativer Ereignisfluss Nr. 1

1. Zu Schritt 4: Das System erkennt, dass die eingegebenen Daten unvollständig oder syntaktisch ungültig sind.
2. Das System zeigt dem Unternehmer erneut die Gesamtübersicht an und markiert alle fehlerhaften Eingabefelder. Zusätzlich wird eine passende Fehlermeldung ausgegeben.
3. Der Unternehmer korrigiert die fehlerhaften Daten direkt in der Gesamtübersicht.
4. Der Unternehmer bestätigt erneut, dass die korrigierten Daten korrekt sind.
5. Das System prüft die Eingaben erneut.
6. Wenn die Daten nun gültig sind, setzt das System den grundlegenden Ereignisfluss bei Schritt 4 fort.
7. Wenn die Daten weiterhin ungültig sind, wird dieser Alternativfluss ab Schritt 2 wiederholt.

---

## TODO 4: Alternativer Ereignisfluss Nr. 2

1. Zu Schritt 7: Der Supplier-Use-Case „Bankeinzug durchführen“ liefert dem System eine
   Fehlermeldung zurück, dass der Bankeinzug nicht durchgeführt werden konnte  
   (z. B. unzureichende Deckung, Konto gesperrt, technische Fehler).  
   Im Use Case „Bankeinzug durchführen“ findet keine Interaktion mit dem Unternehmer statt.

2. Das System zeigt dem Unternehmer eine Ausgabeseite, die den fehlgeschlagenen Bankeinzug
   und – falls verfügbar – den Fehlergrund anzeigt.  
   Zusätzlich wird die aktuell verwendete Bankverbindung angezeigt.

3. Das System bietet dem Unternehmer folgende Optionen:
    - **Bankverbindung prüfen/ändern**
    - **Vorgang abbrechen**

4. Der Unternehmer wählt die Option **„Bankverbindung prüfen/ändern“**.

5. Das System ruft den Supplier-Use-Case **„Bankverbindungen verwalten“** auf,  
   damit der Unternehmer eine andere vorhandene Bankverbindung auswählen  
   oder eine neue Bankverbindung anlegen kann.

6. Nach erfolgreichem Abschluss des Supplier-Use-Cases liegt dem System eine gültige,
   aktualisierte Bankverbindung des Unternehmers vor.

7. Das System startet den Supplier-Use-Case **„Bankeinzug durchführen“** erneut mit der
   aktualisierten Bankverbindung.

8. Ist der Bankeinzug nun erfolgreich, setzt das System den grundlegenden Ereignisfluss
   bei **Schritt 8** fort.

9. Scheitert der Bankeinzug erneut **oder** entscheidet sich der Unternehmer in Schritt 3
   für „Vorgang abbrechen“, zeigt das System eine Fehlermeldung an und beendet den
   Use Case „Projektausschreibung aufgeben“ **ohne** die Ausschreibung zu veröffentlichen.

---

## TODO 5: Nachbedingung

- Im System Coll@HBRS ist **genau eine neue Projektausschreibung** für den ausführenden Unternehmer gespeichert,
  die nachweislich auf den in diesem Use Case eingegebenen und bestätigten Daten basiert.
- Diese Projektausschreibung besitzt den Status **„veröffentlicht“**.
- Die Projektausschreibung ist eindeutig dem Unternehmer zugeordnet (z. B. über eine Unternehmer-ID).
- Die Daten dieser Projektausschreibung wurden erfolgreich an das externe Informationssystem
  des Cloudanbieters übertragen.
- Für diese Projektausschreibung wurde der zugehörige Betrag **erfolgreich per Bankeinzug** von einer
  gültigen Bankverbindung des Unternehmers abgebucht (positives Ergebnis des Use Case
  „Bankeinzug durchführen“ ist im System protokolliert).

---

---

---

---

---

---

---

# TODO 3: Supplier-Use-Case: Bankverbindungen verwalten

## Akteure
**Unternehmer**  


---

## Vorbedingungen
- Der Unternehmer ist im System Coll@HBRS eingeloggt.
- Mindestens 0 Bankverbindungen sind im System gespeichert (leere Liste möglich).

---

## Nachbedingung
- Eine **gültige Bankverbindung** (ausgewählt oder neu angelegt) wurde erfolgreich vom System bestimmt  
  und an den aufrufenden Use Case zurückgegeben.

---

## Grundlegender Ereignisfluss

1. Das System zeigt dem Unternehmer eine Liste aller bereits gespeicherten Bankverbindungen an  
   und bietet zwei Optionen:
    - **Bankverbindung auswählen**
    - **Neue Bankverbindung anlegen**

2. **Variante A – Bankverbindung auswählen**
    - Der Unternehmer wählt eine der vorhandenen Bankverbindungen aus.
    - Das System übernimmt diese als aktuelle Bankverbindung.
    - Der Use Case gibt die ausgewählte Bankverbindung an den aufrufenden Use Case zurück und endet.

3. **Variante B – Neue Bankverbindung anlegen**
    - Der Unternehmer wählt die Option „Neue Bankverbindung anlegen“.
    - Das System zeigt ein Eingabeformular zur Erstellung einer neuen Bankverbindung an  
      (z. B. IBAN, BIC, Kontoinhaber, Name der Bank).
    - Der Unternehmer gibt die Daten ein und bestätigt.
    - Das System prüft die Vollständigkeit und syntaktische Korrektheit der Eingaben.
    - Bei gültigen Daten speichert das System die neue Bankverbindung, fügt sie der Liste hinzu  
      und markiert sie als aktuelle Bankverbindung.
    - Der Use Case gibt die neue Bankverbindung an den aufrufenden Use Case zurück und endet.

---

## Alternativer Ereignisfluss – Fehlerhafte Bankdaten (z. B. falsche IBAN)

1. Zu Schritt 3 (Variante B): Das System erkennt, dass die eingegebenen Bankdaten ungültig oder unvollständig sind.
2. Das System bricht den Speichervorgang ab und zeigt eine Fehlermeldung an.  
   Die problematischen Felder werden markiert, bereits eingegebene Werte bleiben erhalten.
3. Der Unternehmer korrigiert die betroffenen Daten und bestätigt erneut.
4. Das System prüft die korrigierten Daten erneut.
5. Falls die Daten gültig sind, setzt das System den grundlegenden Ereignisfluss bei  
   „Variante B – Neue Bankverbindung anlegen“ fort (nach der Prüfung).
6. Falls die Daten weiterhin ungültig sind, wird dieser Alternativfluss wiederholt (Rücksprung zu Schritt 2).