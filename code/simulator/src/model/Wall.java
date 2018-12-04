package model;

import java.awt.*;

public class Wall {
    private Color color;
    private Coordinate start;
    private Coordinate end;

    public Wall(Color color, Coordinate start, Coordinate end) {
        this.color = color;
        this.start = start;
        this.end = end;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Coordinate getStart() {
        return start;
    }

    public void setStart(Coordinate start) {
        this.start = start;
    }

    public Coordinate getEnd() {
        return end;
    }

    public void setEnd(Coordinate end) {
        this.end = end;
    }
}
