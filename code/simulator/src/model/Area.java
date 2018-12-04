package model;

public class Area {

    private Coordinate start;
    private Coordinate end;

    public Area(Coordinate start, Coordinate end){
        this.start = start;
        this.end = end;
    }

    public Coordinate getStart(){
        return start;
    }

    public Coordinate getEnd(){
        return end;
    }
}
