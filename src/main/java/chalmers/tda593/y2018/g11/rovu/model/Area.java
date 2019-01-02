package chalmers.tda593.y2018.g11.rovu.model;

public class Area {

    private final Coordinate a;
    private final Coordinate b;
    private final int points;

    public Area(Coordinate a, Coordinate b, int points){
        this.a = a;
        this.b = b;
        this.points = points;
    }

    /**
     * With the coordinate of a chalmers.tda593.y2018.g11.rovu.robot, check if said chalmers.tda593.y2018.g11.rovu.robot
     * resides within the area.
     * @param coordinate
     * @return
     */
    public boolean isInArea(Coordinate coordinate){
    	double smallestX = a.getX() > b.getX() ? b.getX() : a.getX();
	    double smallestY = a.getY() > b.getY() ? b.getY() : a.getY();

	    double biggestX = a.getX() <= b.getX() ? b.getX() : a.getX();
	    double biggestY = a.getY() <= b.getY() ? b.getY() : a.getY();

        return coordinate.getX() >= smallestX && coordinate.getX() <= biggestX &&
		        coordinate.getY() >= smallestY && coordinate.getY() <= biggestY;
    }


    public Coordinate getA(){
        return a;
    }

    public Coordinate getB(){
        return b;
    }

    public int getPoints() { return points; }
}
