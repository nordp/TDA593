package chalmers.tda593.y2018.g11.rovu.robot;

import chalmers.tda593.y2018.g11.rovu.model.Coordinate;

public interface Actuator {
	void goTo(Coordinate coordinate);
	void stop();
	void changeColour();
}
