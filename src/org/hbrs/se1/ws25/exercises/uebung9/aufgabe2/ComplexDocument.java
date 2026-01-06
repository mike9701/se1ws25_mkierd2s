package org.hbrs.se1.ws25.exercises.uebung9.aufgabe2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComplexDocument implements Document {
    private String id;
    private final List<Document> children = new ArrayList<>();

    public void add(Document doc) {
        if (doc == null) return;
        children.add(doc);
    }

    public void remove(Document doc) {
        children.remove(doc);
    }

    // Optional: falls du die Kinder mal anzeigen/debuggen willst
    public List<Document> getChildren() {
        return Collections.unmodifiableList(children);
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public int getSizeInBytes() {
        int sum = 0;
        for (Document d : children) {
            if (d != null) sum += d.getSizeInBytes();
        }
        return sum;
    }
}