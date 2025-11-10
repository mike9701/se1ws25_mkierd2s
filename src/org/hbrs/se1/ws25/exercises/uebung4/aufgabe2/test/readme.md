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

| **TestCase No.** | **Category** | **Input** | **Output (erw. Ergebnis)** |
|------------------:|:------------:|------------|-----------------------------|
| **01** | ✅ Positiv | `help` | Liste aller verfügbaren Befehle wird angezeigt. |
| **02** | ✅ Positiv | `enter` | Interaktive Eingabe startet. Nach Eingabe aller Felder wird die User Story bestätigt und im Speicher abgelegt. |
| **03** | ✅ Positiv | `dump` | Alle vorhandenen User Stories werden nach Priorität (absteigend) angezeigt. |
| **04** | ✅ Positiv | `dump project HBRS` | Nur User Stories des Projekts *HBRS* werden angezeigt. |
| **05** | ⚠️ Negativ | `dump project <unbekannt>` | Ausgabe: *„Keine User Stories vorhanden.“* |
| **06** | ⚠️ Negativ | `dump xyz` | Fehlermeldung: *„Unbekannter Befehl. Verwendung: 'dump' oder 'dump project <Name>'“* |
| **07** | ✅ Positiv | `store` | User Stories werden persistent in `userstories.ser` gespeichert. Ausgabe: *„User Stories gespeichert.“* |
| **08** | ✅ Positiv | `load` | User Stories werden aus `userstories.ser` geladen. Ausgabe: *„User Stories geladen.“* |
| **09** | ⚠️ Negativ | `enter` → Eingabe negativer Werte (z. B. Risiko = −1) | Fehlermeldung: *„Risiko darf nicht negativ sein!“* |
| **10** | ⚠️ Negativ | `enter` → doppelte ID eingeben | Fehlermeldung: *„Das UserStory-Objekt mit der ID … ist bereits vorhanden!“* |
| **11** | ✅ Positiv | `exit` | Programm beendet sich ordnungsgemäß mit Ausgabe *„Bye!“* |

---

## Äquivalenzklassen Klasse UserStory

| **Parameter** | **Äquivalenzklasse** | **Repräsentant (Beispielwert)** | **Category** |
|----------------|----------------------|----------------------------------|--------------|
| `id` | positive ganze Zahl | 1 | ✅ Positiv |
| `id` | null oder negative Zahl | -5 | ⚠️ Negativ |
| `title` | nicht leerer String | "Raumreservierung" | ✅ Positiv |
| `title` | leerer String oder null | "" | ⚠️ Negativ |
| `acceptanceCriterion` | gültige Beschreibung | "Raum kann gebucht werden" | ✅ Positiv |
| `acceptanceCriterion` | leer oder null | null | ⚠️ Negativ |
| `project` | gültiger Projektname | "HBRS" | ✅ Positiv |
| `project` | leer oder null | "" | ⚠️ Negativ |
| `mehrwert` | ≥ 0 | 8.0 | ✅ Positiv |
| `mehrwert` | < 0 | -1.0 | ⚠️ Negativ |
| `strafe` | ≥ 0 | 2.0 | ✅ Positiv |
| `strafe` | < 0 | -3.0 | ⚠️ Negativ |
| `aufwand` | ≥ 0 | 4.0 | ✅ Positiv |
| `aufwand` | < 0 | -2.0 | ⚠️ Negativ |
| `risiko` | ≥ 0 | 1.0 | ✅ Positiv |
| `risiko` | < 0 | -1.0 | ⚠️ Negativ |
| `(aufwand + risiko)` | Summe > 0 | Aufwand=3, Risiko=1 | ✅ Positiv |
| `(aufwand + risiko)` | Summe ≤ 0 | Aufwand=0, Risiko=0 | ⚠️ Negativ |

---

## Äquivalenzklassen Klasse Container

| **Parameter / Methode** | **Äquivalenzklasse** | **Repräsentant (Beispielwert)** | **Category** |
|---------------------------|----------------------|----------------------------------|--------------|
| `addUserStory()` | neues, gültiges Objekt | UserStory(ID=1, Projekt="HBRS") | ✅ Positiv |
| `addUserStory()` | null-Referenz | null | ⚠️ Negativ |
| `addUserStory()` | doppelte ID | ID=1 existiert bereits | ⚠️ Negativ |
| `deleteUserStory()` | existierende ID | ID=1 | ✅ Positiv |
| `deleteUserStory()` | nicht vorhandene ID | ID=999 | ⚠️ Negativ |
| `store()` | Persistenzstrategie gesetzt | Strategy=PersistenceStrategyStream | ✅ Positiv |
| `store()` | keine Strategie gesetzt | Strategy=null | ⚠️ Negativ |
| `load()` | Datei vorhanden | "userstories.ser" vorhanden | ✅ Positiv |
| `load()` | Datei fehlt oder fehlerhaft | "userstories.ser" fehlt | ⚠️ Negativ |
| `getCurrentList()` | lesender Zugriff | list.size() | ✅ Positiv |
| `getCurrentList()` | Versuch, Liste zu verändern | list.add(...) | ⚠️ Negativ |

---

## Äquivalenzklassen Klasse InputDialog

| **Parameter / Eingabe** | **Äquivalenzklasse** | **Repräsentant (Beispielwert)** | **Category** |
|---------------------------|----------------------|----------------------------------|--------------|
| `Befehle` | gültiger Befehl | `enter`, `dump`, `store`, `load`, `exit`, `help` | ✅ Positiv |
| `Befehle` | ungültiger Befehl | `xyz`, `dump abc` | ⚠️ Negativ |
| `dump project` | existierendes Projekt | `dump project HBRS` | ✅ Positiv |
| `dump project` | unbekanntes Projekt | `dump project Unbekannt` | ⚠️ Negativ |
| `Numerische Eingabe` | gültige Zahl ≥ 0 | `5` | ✅ Positiv |
| `Numerische Eingabe` | ungültige Zahl < 0 | `-2` | ⚠️ Negativ |
| `Numerische Eingabe` | keine Zahl | `abc` | ⚠️ Negativ |
| `Text-Eingabe` | nicht leerer String | `"Geräteraum"` | ✅ Positiv |
| `Text-Eingabe` | leerer String | `""` | ⚠️ Negativ |
| `store` / `load` | Strategie korrekt gesetzt | Datei: `userstories.ser` | ✅ Positiv |
| `store` / `load` | keine Strategie oder defekte Datei | Datei fehlt oder beschädigt | ⚠️ Negativ |
| `exit` | Programm korrekt beenden | `exit` | ✅ Positiv |

---

## Hinweise zur Testdurchführung

1. Programm starten (z. B. `java Main`).
2. Befehle nacheinander gemäß Tabelle eingeben.
3. Nach jedem Schritt prüfen, ob die erwartete Konsolenausgabe erscheint.
4. Zwischen `store` und `load`-Tests kann das Programm beendet und neu gestartet werden, um die Persistenz zu prüfen.
5. Negative oder ungültige Eingaben bewusst testen, um Fehlermeldungen zu verifizieren.

---

## Bewertungskriterien

Ein Test gilt als **bestanden**, wenn:
- die jeweilige erwartete Ausgabe exakt angezeigt wird,
- keine unbehandelten Exceptions auftreten,
- die Konsolenlogik (Eingabe, Ausgabe, Persistenz) nachvollziehbar funktioniert.

---

## Abschluss

Wenn alle Tests aus dieser README erfolgreich sind,  
ist die Anwendung *AllMyResources@HBRS* funktional korrekt,  
benutzerfreundlich bedienbar und erfüllt die Anforderungen der Aufgabe 4-2.