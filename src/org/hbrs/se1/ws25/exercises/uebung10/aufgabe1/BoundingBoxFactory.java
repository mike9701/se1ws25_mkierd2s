package org.hbrs.se1.ws25.exercises.uebung10.aufgabe1;

public class BoundingBoxFactory {

    private BoundingBoxFactory() {
        // Utility-Klasse: keine Instanzen
    }

    public static MyPrettyRectangle createBoundingBox(MyPrettyRectangle[] rects) {
        if (rects == null) {
            return null;
        }
        if (rects.length == 0) {
            return new MyPrettyRectangle(0.0, 0.0, 0.0, 0.0);
        }

        double minX1 = Double.POSITIVE_INFINITY;
        double minY1 = Double.POSITIVE_INFINITY;
        double maxX2 = Double.NEGATIVE_INFINITY;
        double maxY2 = Double.NEGATIVE_INFINITY;

        for (MyPrettyRectangle r : rects) {
            if (r == null) {
                // Optional: null-Elemente ignorieren (oder Exception werfen – aber Tests sagen dazu nichts)
                continue;
            }
            minX1 = Math.min(minX1, r.getX1());
            minY1 = Math.min(minY1, r.getY1());
            maxX2 = Math.max(maxX2, r.getX2());
            maxY2 = Math.max(maxY2, r.getY2());
        }

        // Falls Array nur aus null-Elementen bestand:
        if (minX1 == Double.POSITIVE_INFINITY) {
            return new MyPrettyRectangle(0.0, 0.0, 0.0, 0.0);
        }

        return new MyPrettyRectangle(minX1, minY1, maxX2, maxY2);
    }
}
