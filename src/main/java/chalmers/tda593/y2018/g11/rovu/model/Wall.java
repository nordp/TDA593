package chalmers.tda593.y2018.g11.rovu.model;


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
