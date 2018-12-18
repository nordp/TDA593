package robot;

import model.Coordinate;
import project.AbstractRobotSimulator;
import project.Point;

import javax.vecmath.Color3f;

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
		this.setDestination(new Point(coordinate.getX(),coordinate.getY()));
	}

	@Override
	public void stop() {
		this.setDestination(this.getPosition());
	}

	@Override
	public Boolean checkObstacles() {
		throw new Error("Not Implemented");
	}

	@Override
	public Coordinate getCoordinate() {
		return new Coordinate(getPosition().getX(),getPosition().getZ());
	}

	@Override
	public Boolean checkCamera() {
		throw new Error("Not Implemented");
	}

	@Override
	public void changeColour() {
		this.changeColor(new Color3f((float)Math.random(), (float)Math.random(), (float)Math.random()));
	}
}
