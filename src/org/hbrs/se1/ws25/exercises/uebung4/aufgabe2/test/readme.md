# README – Manuelle Tests für *AllMyResources@HBRS* (Aufgabe 4-2)

## Ziel
Diese Tests dienen der **manuellen Überprüfung** der Funktionalität des Tools zur Verwaltung von User Stories.  
Geprüft wird, ob das System aus Anwendersicht korrekt reagiert und alle Konsolenbefehle wie vorgesehen funktionieren.

---

## Testart: End-to-End / Akzeptanztests
Die folgenden Testfälle werden **manuell über die Konsole** (InputDialog) durchgeführt.  
Eine Testautomatisierung (JUnit) ist **nicht Bestandteil** dieser README.

### 🔧 Testumgebung
- Programmiersprache: Java 17 oder höher
- Startklasse: Main
- Ein-/Ausgabe: Konsole (Terminal, Shell, CMD)
- Speicherdatei: `userstories.ser`

---

## Testfälle

| **Test-ID** | **Aktion / Eingabe** | **Erwartetes Verhalten / Ausgabe** |
|--------------|----------------------|------------------------------------|
| **E2E-01** | `help` | Liste aller verfügbaren Befehle wird angezeigt. |
| **E2E-02** | `enter` | Interaktive Eingabe startet. Nach Eingabe aller Felder wird die User Story bestätigt und im Speicher abgelegt. |
| **E2E-03** | `dump` | Alle vorhandenen User Stories werden nach Priorität (absteigend) angezeigt. |
| **E2E-04** | `dump project HBRS` | Nur User Stories des Projekts *HBRS* werden angezeigt. |
| **E2E-05** | `dump project <unbekannt>` | Es erfolgt die Ausgabe: *„Keine User Stories vorhanden.“* |
| **E2E-06** | `dump xyz` | Fehlermeldung: *„Unbekannter Befehl. Verwendung: 'dump' oder 'dump project <Name>'“* |
| **E2E-07** | `store` | Aktuell gespeicherte User Stories werden in `userstories.ser` persistent gespeichert. Bestätigung: *„User Stories gespeichert.“* |
| **E2E-08** | `load` | User Stories werden aus der Datei `userstories.ser` geladen. Bestätigung: *„User Stories geladen.“* |
| **E2E-09** | `enter` → Eingabe negativer Werte (z. B. Risiko = −1) | Fehlermeldung: *„Risiko darf nicht negativ sein!“* |
| **E2E-10** | `enter` → doppelte ID eingeben | Fehlermeldung: *„Das UserStory-Objekt mit der ID … ist bereits vorhanden!“* |
| **E2E-11** | `exit` | Programm beendet sich ordnungsgemäß mit Ausgabe *„Bye!“* |

---

## Hinweise zur Testdurchführung

1. Programm starten (z. B. `java Main`).
2. Befehle nacheinander gemäß Tabelle eingeben.
3. Nach jedem Schritt prüfen, ob die erwartete Konsolenausgabe erscheint.
4. Zwischen `store` und `load`-Tests kann das Programm beendet und neu gestartet werden, um die Persistenz zu prüfen.
5. Negative oder ungültige Eingaben bewusst testen, um Fehlermeldungen zu verifizieren.

---

## 📋 Bewertungskriterien

Ein Test gilt als **bestanden**, wenn:
- die jeweilige erwartete Ausgabe exakt angezeigt wird,
- keine unbehandelten Exceptions auftreten,
- die Konsolenlogik (Eingabe, Ausgabe, Persistenz) nachvollziehbar funktioniert.

---

## 🏁 Abschluss

Wenn alle Tests aus dieser README erfolgreich sind,  
ist die Anwendung *AllMyResources@HBRS* funktional korrekt,  
benutzerfreundlich bedienbar und erfüllt die Anforderungen der Aufgabe 4-2.