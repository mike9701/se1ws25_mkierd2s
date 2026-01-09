package org.hbrs.se1.ws25.exercises.uebung10.aufgabe1;

import java.util.Objects;

/**
 * Repräsentiert einen Punkt im kartesischen Koordinatensystem
 */
public class MyPoint {

    private final double x;
    private final double y;

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MyPoint)) return false;
        MyPoint other = (MyPoint) obj;

        // Vergleich mit Double.compare (sauberer als ==)
        return Double.compare(x, other.x) == 0
                && Double.compare(y, other.y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}