package robot;

import model.Coordinate;

public interface Actuator {
	void goTo(Coordinate coordinate);
	void stop();
	void changeColour();
}
