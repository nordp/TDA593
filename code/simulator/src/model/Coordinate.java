package model;

import java.util.Objects;

public class Coordinate {
    private final double x;
    private final double y;
    public static final double MARGIN_OF_ERROR = 0.2;

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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        Double diffX = Math.abs(that.x - x);
        Double diffY = Math.abs(that.y - y);
        return diffX <= MARGIN_OF_ERROR &&
                diffY <= MARGIN_OF_ERROR;
    }

    public String toString() {
        return "X = " + this.x + ", Y = " + this.y;
    }
}