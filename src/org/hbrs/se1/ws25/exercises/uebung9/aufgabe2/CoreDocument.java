package org.hbrs.se1.ws25.exercises.uebung9.aufgabe2;

public abstract class CoreDocument implements Document {
    private String id;

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public abstract int getSizeInBytes();
}