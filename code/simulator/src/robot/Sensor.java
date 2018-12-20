package robot;

import model.Coordinate;

public interface Sensor {
	Coordinate getCoordinate();
	boolean checkCamera();
	boolean checkObstacles();
    boolean isInMotion();
}
