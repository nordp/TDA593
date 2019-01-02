package chalmers.tda593.y2018.g11.rovu.robot;

import chalmers.tda593.y2018.g11.rovu.model.Coordinate;
import project.AbstractRobotSimulator;
import project.Point;

import javax.vecmath.Color3f;

public class SimulatorRobot extends AbstractRobotSimulator implements Actuator, Sensor {
	// Constructor takes cmd point because its implementation specific

	private double zConversion = 8;
	private double xConversion = 8;
	private boolean isInMotion = false;

	public SimulatorRobot(Point position, String name) {
		super(position, name);
	}

	@Override
	public String toString() {
		return "Robot " + this.getName();
	}

	@Override
	public void goTo(Coordinate coordinate) {
		this.isInMotion = true;
		this.setDestination(coordinateToPoint(coordinate));
	}

	@Override
	public void stop() {
		this.isInMotion = false;
		this.setDestination(this.getPosition());
	}

	@Override
	public boolean checkObstacles() {
		return super.checkObstacle();
	}

	@Override
	public boolean isInMotion() {
		return isInMotion;
	}

	@Override
	public Coordinate getCoordinate() {
		return pointToCoordinate(getPosition());
	}

	@Override
	public boolean checkCamera() {
		return super.checkCameraDetection();
	}

	@Override
	public void changeColour() {
		this.changeColor(new Color3f((float)Math.random(), (float)Math.random(), (float)Math.random()));
	}

	Coordinate pointToCoordinate(Point point){
		return pointToCoordinate(point, xConversion, zConversion);
	}
	static Coordinate pointToCoordinate(Point point, double xConversion, double zConversion){
		return new Coordinate(zConversion - point.getZ(), point.getX() + xConversion);
	}

	Point coordinateToPoint(Coordinate coordinate){
		return coordinateToPoint(coordinate, xConversion, zConversion);
	}
	static Point coordinateToPoint(Coordinate coordinate, double xConversion, double zConversion){
		return new Point(coordinate.getY() - xConversion, -coordinate.getX() + zConversion);
	}
}
