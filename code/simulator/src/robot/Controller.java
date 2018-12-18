package robot;

import model.Coordinate;
import model.Instruction;
import model.Status;
import robot.routines.*;
import robot.routines.actions.Action;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Controller implements Runnable {
	private List<Routine> routines = new LinkedList<>();
	private Status lastStatus;
	private Actuator actuator;
	private Sensor sensor;

	Controller(int id, Actuator actuator, Sensor sensor) {
		this.actuator = actuator;
		this.sensor = sensor;

		// Setup routines
		routines.add(new EmergencyStopRoutine());
		routines.add(new RobotFailureRoutine());
		routines.add(new CollisionPreventionRoutine());
		routines.add(new ColourRoutine());
		routines.add(new MissionReachedRoutine());
		routines.add(new NavigateToNextRoutine());

		lastStatus = new Status(id, null, false, null);

		Thread t = new Thread(this);
		t.setDaemon(true);
		t.start();
	}

	Status getStatus() {
		return this.lastStatus;
	}

	void setInstruction(Instruction instruction) {
        Map<Class, Instruction> instructions = lastStatus.getInstructions();
        instructions.put(instruction.getClass(), instruction);
        lastStatus = new Status(lastStatus.getId(), lastStatus.getLocation(), lastStatus.isInMotion(), instructions);	}

	@Override
	public void run() {
		while(true){
			// update status
			this.lastStatus = new Status(
					this.lastStatus.getId(),
					this.sensor.getCoordinate(),
					lastStatus.isInMotion(),
					this.lastStatus.getInstructions()
			);

			boolean blocked = false;
			for(Routine routine : routines){
				Action a = routine.calculateAction(lastStatus);
				if(a != null){
					if (a.blocking()) {
						if (!blocked) {
							blocked = true;
							a.execute(actuator);
						}
					} else {
						a.execute(actuator);
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
