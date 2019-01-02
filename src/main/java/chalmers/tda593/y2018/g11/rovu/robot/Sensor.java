package chalmers.tda593.y2018.g11.rovu.robot;

import chalmers.tda593.y2018.g11.rovu.model.Coordinate;

public interface Sensor {
	Coordinate getCoordinate();
	boolean checkCamera();
	boolean checkObstacles();
    boolean isInMotion();
}
