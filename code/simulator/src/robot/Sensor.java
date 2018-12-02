package robot;

import model.Coordinate;

public interface Sensor {
	Coordinate getCoordinate();
	Boolean checkCamera();
	Boolean checkObstacles();
}
