package org.hbrs.se1.ws25.exercises.uebung8.aufgabe1;

public class ReiseAnbieterAdapter implements HotelAnbieter {

    private ReiseAnbieter system;

    public ReiseAnbieterAdapter(ReiseAnbieter system) {
        this.system = system;
    }

    @Override
    public SuchErgebnis suche(SuchAuftrag s) {
        QueryObject q = transformIN(s);
        QueryResult r = system.executeQuery(q);
        return transformOUT(r);
    }

    private QueryObject transformIN(SuchAuftrag s) {
        // Transformation andeuten
        throw new UnsupportedOperationException();
    }

    private SuchErgebnis transformOUT(QueryResult r) {
        // Transformation andeuten
        throw new UnsupportedOperationException();
    }
}
