package org.hbrs.se1.ws25.exercises.uebung9.aufgabe2;

public class GraficDocument extends CoreDocument {
    private final String url;
    private static final int SIZE_IN_BYTES = 1200;

    public GraficDocument(String url) {
        this.url = url == null ? "" : url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public int getSizeInBytes() {
        return SIZE_IN_BYTES;
    }
}