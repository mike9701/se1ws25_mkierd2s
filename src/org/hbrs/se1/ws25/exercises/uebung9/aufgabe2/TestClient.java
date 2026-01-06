package org.hbrs.se1.ws25.exercises.uebung9.aufgabe2;

public class TestClient {
    public static void main(String[] args) {

        // doc0 : ComplexDocument (Wurzel)
        ComplexDocument doc0 = new ComplexDocument();
        doc0.setId("doc0");

        // doc2 : TextDocument (Kind von doc0)
        TextDocument doc2 = new TextDocument(
                "Die Klausur im Fach SE findet bald im März 2026 statt!",
                TextDocument.Encoding.UTF16
        );
        doc2.setId("doc2");

        // doc3 : ComplexDocument (Kind von doc0)
        ComplexDocument doc3 = new ComplexDocument();
        doc3.setId("doc3");

        // doc5 : TextDocument (Kind von doc3)
        TextDocument doc5 = new TextDocument(
                "Software Engineering I ist eine Vorlesung in den Studiengaengen BWI und BCSP!",
                TextDocument.Encoding.UTF32
        );
        doc5.setId("doc5");

        // doc4 : GraficDocument (Kind von doc3)
        GraficDocument doc4 = new GraficDocument("localhost:8080");
        doc4.setId("doc4");

        // Hierarchie wie in der Abbildung:
        // doc0 -> doc2, doc3
        // doc3 -> doc5, doc4
        doc0.add(doc2);
        doc0.add(doc3);
        doc3.add(doc5);
        doc3.add(doc4);

        // Ausgabe Einzelgrößen + Gesamtgröße
        System.out.println(doc2.getId() + " size: " + doc2.getSizeInBytes() + " bytes");
        System.out.println(doc5.getId() + " size: " + doc5.getSizeInBytes() + " bytes");
        System.out.println(doc4.getId() + " size: " + doc4.getSizeInBytes() + " bytes");

        int total = doc0.getSizeInBytes();
        System.out.println("TOTAL (doc0): " + total + " bytes");

        // Mini-Demo remove (optional):
        // doc3.remove(doc4);
        // System.out.println("TOTAL after removing doc4: " + doc0.getSizeInBytes() + " bytes");
    }
}
