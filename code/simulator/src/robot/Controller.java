package robot;

import control_station.RobotInterface;
import model.Instruction;
import model.Status;
import robot.routines.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.LinkedList;
import java.util.List;

public class Controller implements Runnable {
	private List<Routine> routines = new LinkedList<>();
	private Status lastStatus = null;
	private Actuator actuator;
	private Sensor sensor;

	public Controller(Actuator actuator, Sensor sensor, RobotInterface contolStation) {
		this.actuator = actuator;
		this.sensor = sensor;

		// Setup routines
		routines.add(new EmergencyStopRoutine());
		routines.add(new RobotFailureRoutine());
		routines.add(new CollisionPreventionRoutine());
		routines.add(new MissionReachedRoutine());
		routines.add(new NavigateToNextRoutine());

		new ControlStationInterface(this, contolStation);

		// TODO start the run loop
		new Thread(this).setDaemon(true);
	}

	Status getStatus() {
		return this.lastStatus;
	}

	void setInstruction(Instruction instruction) {
		throw new NotImplementedException();
	}

	@Override
	public void run() {
		throw new NotImplementedException();
	}
}
