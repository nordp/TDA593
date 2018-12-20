package model;

public class Coordinate {
    private final double x;
    private final double y;

    public Coordinate(double x, double y) {
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
    public boolean equals(Object o) {
        if (o instanceof Coordinate) {
            Coordinate c = (Coordinate) o;
            return (this.x == c.getX() && (this.y == c.getY()));
        }
        return false;
    }


    public String toString() {
        return "X = " + this.x + ", Y = " + this.y;
    }
}