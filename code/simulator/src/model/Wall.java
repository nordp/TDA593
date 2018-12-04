package model;


public class Wall {
    private final Coordinate start;
    private final Coordinate end;

    public Wall(Coordinate start, Coordinate end) {
        this.start = start;
        this.end = end;
    }

    public Coordinate getStart() {
        return start;
    }

    public Coordinate getEnd() {
        return end;
    }
}
