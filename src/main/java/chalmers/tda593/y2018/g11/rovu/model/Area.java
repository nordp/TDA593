package chalmers.tda593.y2018.g11.rovu.model;

public class Area {

    private final Coordinate start;
    private final Coordinate end;
    private final int points;

    public Area(Coordinate start, Coordinate end, int points){
        this.start = start;
        this.end = end;
        this.points = points;
    }

    /**
     * With the coordinate of a chalmers.tda593.y2018.g11.rovu.robot, check if said chalmers.tda593.y2018.g11.rovu.robot
     * resides within the area.
     * @param coordinate
     * @return
     */
    public boolean isInArea(Coordinate coordinate){
        return (coordinate.getX() >= start.getX() && coordinate.getX() <= end.getX()) &&
                (coordinate.getY() >= start.getY() && coordinate.getY() <= end.getY());
    }


    public Coordinate getStart(){
        return start;
    }

    public Coordinate getEnd(){
        return end;
    }

    public int getPoints() { return points; }
}
