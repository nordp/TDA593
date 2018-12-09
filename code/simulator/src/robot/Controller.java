package robot;

import control_station.RobotInterface;
import model.Coordinate;
import model.Instruction;
import model.Status;
import robot.routines.*;
import robot.routines.actions.Action;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Controller implements Runnable {
	private List<Routine> routines = new LinkedList<>();
	private Status lastStatus;
	private Actuator actuator;
	private Sensor sensor;
	//TODO TEMP
	public ControlStationInterface controlStationInterface;

	public Controller(Actuator actuator, Sensor sensor, RobotInterface controlStation) {
		this.actuator = actuator;
		this.sensor = sensor;

		// Setup routines
		routines.add(new EmergencyStopRoutine());
		routines.add(new RobotFailureRoutine());
		routines.add(new CollisionPreventionRoutine());
		routines.add(new ColourRoutine());
		routines.add(new MissionReachedRoutine());
		routines.add(new NavigateToNextRoutine());

		controlStationInterface = new ControlStationInterface(this, controlStation);

		actuator.goTo(new Coordinate(2,2));

		lastStatus = new Status(0, null, false, null);

		// TODO start the run loop
		Thread t = new Thread(this);
		t.setDaemon(true);
		t.start();

	}

	Status getStatus() {
		return this.lastStatus;
	}

	void setInstruction(Instruction instruction) {
		Set<Instruction> instructions = lastStatus.getInstructions();
		instructions.remove(instruction);
		instructions.add(instruction);
		lastStatus = new Status(lastStatus.getId(), lastStatus.getLocation(), lastStatus.isInMotion(), instructions);

	}

	@Override
	public void run() {
		while(true){
			for(Routine routine : routines){
				Action a = routine.calculateAction(lastStatus);
				if(a != null){
					a.execute(actuator);
					if (a.blocking()) {
						break;
					}
				}
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
