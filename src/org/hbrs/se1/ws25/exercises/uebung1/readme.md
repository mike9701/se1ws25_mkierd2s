# Übung01, Mike Kierdorf  
## Aufgabe 1.1  
### Factory Klasse  
Die Klasse „Client“ darf kein Translator-Objekt mit new erzeugen, sondern muss dies über eine zusätzliche „Factory“-Klasse anfordern.  
Die Factory übernimmt die Instanzerzeugung und setzt dabei auch automatisch das Erstellungsdatum des Translators:  
```
public class TranslatorFactory {  
    public static Translator createGermanTranslator(){  
        GermanTranslator translator = new GermanTranslator();  
        translator.setDate("Okt/2025");  
        return translator;  
    }   
}
```
Die Factory liegt im „control“ Package (Uebung01.control).  

### Entwurfsmuster  
Das eingesetzte Entwurfsmuster ist das Factory Method Pattern (oft auch einfach „Factory Pattern“ genannt).  
Softwaretechnischer Nutzen:  
⦁	Entkopplung von Objekt-Erzeugung und -Nutzung → Client kennt nur das Interface, nicht die konkrete Klasse.  
⦁	Erweiterbarkeit → neue Übersetzer (z. B. EnglishTranslator, FrenchTranslator) können hinzugefügt werden, ohne den Client-Code zu ändern.  
⦁	Wartbarkeit & Konsistenz → zentrale Stelle für Initialisierung (z. B. Datum setzen, Logging, Konfiguration).  

### Anpassung am Interface  
Um Kompilierfehler zu vermeiden, muss die Sichtbarkeit des Interface Translator auf public gesetzt werden, weil der Client in einem anderen Package liegt und streng gegen das Interface implementieren soll.


## Aufgabe 1.3
### Vorteil separate Test-Klasse
⦁	Trennung von Produktion und Test: Testcode und Produktivcode sind klar voneinander getrennt.  
⦁	Saubere Projektstruktur: Tests liegen in einem eigenen Package (Uebung01.test).  
⦁	Automatisierbarkeit: Tests können unabhängig vom Client automatisiert mit JUnit ausgeführt werden.  
⦁	Wiederverwendbarkeit: Die Klasse kann unabhängig vom „View“-Code (Client) getestet werden.  
### Sinn von Äquivalenzklassen im Blackbox-Test
⦁	Reduktion der Testfälle: Man muss nicht alle Eingaben prüfen, sondern wählt repräsentative Werte aus jeder Klasse.  
⦁	Repräsentativität: Ein Wert aus der Klasse repräsentiert das Verhalten für alle Werte dieser Klasse.  
⦁	Systematische Abdeckung: Jede mögliche Art von Eingabe (gültig, ungültig klein, ungültig groß) wird getestet.  
### Warum Blackbox-Test mit JUnit auf „Client“ nicht unmittelbar möglich ist
⦁	Client hat keine eigene Logik zur Zahlübersetzung, sondern delegiert nur an den Translator.  
⦁	Ein Blackbox-Test testet die Schnittstelle und das Verhalten nach außen. Beim Client gibt es nur eine display()-Methode, die direkt auf die Konsole schreibt.  
⦁	JUnit kann aber nicht direkt Konsolenausgaben vergleichen → man müsste Umwege über System.out-Redirects gehen.  
⦁	Daher testet man sinnvollerweise den GermanTranslator (die Logikklasse) mit JUnit, während der Client eher per Integrationstest geprüft wird.  