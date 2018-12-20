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
	public Boolean checkObstacles() { return super.checkObstacle(); }

	@Override
	public Coordinate getCoordinate() {
		return new Coordinate(8 - getPosition().getZ(),getPosition().getX() + 8);
	}

	@Override
	public Boolean checkCamera() {
		return super.checkCameraDetection();
	}

	@Override
	public void changeColour() {
		this.changeColor(new Color3f((float)Math.random(), (float)Math.random(), (float)Math.random()));
	}
}
