package robot;

import model.Coordinate;
import project.AbstractRobotSimulator;
import project.Point;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class SimulatorRobot extends AbstractRobotSimulator implements Actuator, Sensor {
	// Constructor takes cmd point because its implementation specific
	public SimulatorRobot(Point position, String name) {
		super(position, name);

	}

	@Override
	public String toString() {
		return "Robot " + this.getName();
	}

	@Override
	public void goTo(Coordinate coordinate) {
		throw new NotImplementedException();
	}

	@Override
	public void stop() {
		resetPosition(getPosition());
	}

	@Override
	public Boolean checkObstacles() {
		throw new NotImplementedException();
	}

	@Override
	public Coordinate getCoordinate() {
		throw new NotImplementedException();
	}

	@Override
	public Boolean checkCamera() {
		throw new NotImplementedException();
	}
}
