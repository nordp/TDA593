package robot;

import control_station.RobotInterface;
import model.Coordinate;
import model.Instruction;
import model.Status;
import robot.routines.*;
import robot.routines.actions.Action;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.LinkedList;
import java.util.List;

public class Controller implements Runnable {
	private List<Routine> routines = new LinkedList<>();
	private Status lastStatus = null;
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
		routines.add(new MissionReachedRoutine());
		routines.add(new NavigateToNextRoutine());

		controlStationInterface = new ControlStationInterface(this, controlStation);

		actuator.goTo(new Coordinate(2,2));

		lastStatus = new Status();

		// TODO start the run loop
		Thread t = new Thread(this);
		t.setDaemon(true);
		t.start();

	}

	Status getStatus() {
		return this.lastStatus;
	}

	void setInstruction(Instruction instruction) {
		lastStatus.getInstructions().add(instruction);

	}

	@Override
	public void run() {
		while(true){
			System.out.println(lastStatus.getInstructions().size());
			for(Routine routine : routines){
				Action a = routine.calculateAction(lastStatus);
				if(a != null){
					System.out.println("EMERGENCY");
					a.execute(actuator);
					break;
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
