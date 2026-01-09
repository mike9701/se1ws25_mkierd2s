package org.hbrs.se1.ws25.exercises.uebung10.aufgabe1;

public class MyPrettyRectangle {
    private final double x1; // links unten
    private final double y1;
    private final double x2; // rechts oben
    private final double y2;

    /**
     * Konstruktor
     *
     * @param x1 x-Koordinate links unten
     * @param y1 y-Koordinate links unten
     * @param x2 x-Koordinate rechts oben
     * @param y2 y-Koordinate rechts oben
     */
    public MyPrettyRectangle(double x1, double y1, double x2, double y2) {
        if (x2 < x1 || y2 < y1) {
            throw new IllegalArgumentException("Ungültige Rechteckkoordinaten");
        }
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    /**
     * Prüft, ob dieses Rechteck ein anderes vollständig enthält.
     *
     * @param other das zu prüfende Rechteck
     * @return true, wenn other vollständig in diesem Rechteck liegt
     */
    public boolean contains(MyPrettyRectangle other) {
        if (other == null) {
            return false;
        }

        return this.x1 <= other.x1 &&
                this.y1 <= other.y1 &&
                this.x2 >= other.x2 &&
                this.y2 >= other.y2;
    }

    public MyPoint getCenter() {
        double centerX = (this.x1 + this.x2) / 2.0;
        double centerY = (this.y1 + this.y2) / 2.0;
        return new MyPoint(centerX, centerY);
    }

    /**
     * Berechnet die Fläche des Rechtecks (in cm²)
     *
     * @return Fläche als double
     */
    public double getArea() {
        double width = this.x2 - this.x1;
        double height = this.y2 - this.y1;
        return width * height;
    }

    /**
     * Berechnet den Umfang des Rechtecks (in cm)
     *
     * @return Umfang als double
     */
    public double getPerimeter() {
        double width = this.x2 - this.x1;
        double height = this.y2 - this.y1;
        return 2 * (width + height);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MyPrettyRectangle)) return false;

        MyPrettyRectangle other = (MyPrettyRectangle) obj;

        return Double.compare(this.x1, other.x1) == 0 &&
                Double.compare(this.y1, other.y1) == 0 &&
                Double.compare(this.x2, other.x2) == 0 &&
                Double.compare(this.y2, other.y2) == 0;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(x1, y1, x2, y2);
    }

    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }

    public double getX2() {
        return x2;
    }

    public double getY2() {
        return y2;
    }
}
