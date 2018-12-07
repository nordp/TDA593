package model;

public class Area {

    private final Coordinate start;
    private final Coordinate end;

    public Area(Coordinate start, Coordinate end){
        this.start = start;
        this.end = end;
    }

    /**
     * With the coordinate of a robot, check if said robot
     * resides within the area.
     * @param coordinate
     * @return
     */
    public boolean isRobotInArea(Coordinate coordinate){
        return (coordinate.getX() >= start.getX() || coordinate.getX() <= end.getX()) &&
                (coordinate.getY() >= start.getY() || coordinate.getY() <= end.getY());
    }

    public Coordinate getStart(){
        return start;
    }

    public Coordinate getEnd(){
        return end;
    }
}
