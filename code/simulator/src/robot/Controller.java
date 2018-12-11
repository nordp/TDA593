package robot;

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

	public Controller(Actuator actuator, Sensor sensor) {
		this.actuator = actuator;
		this.sensor = sensor;

		// Setup routines
		routines.add(new EmergencyStopRoutine());
		routines.add(new RobotFailureRoutine());
		routines.add(new CollisionPreventionRoutine());
		routines.add(new ColourRoutine());
		routines.add(new MissionReachedRoutine());
		routines.add(new NavigateToNextRoutine());

		lastStatus = new Status(0, null, false, null);

		Thread t = new Thread(this);
		t.setDaemon(true);
		t.start();
	}

	Status getStatus() {
		return this.lastStatus;
	}

	void setInstruction(Instruction instruction) {
		System.out.println("SetInstruction!!");
        Set<Instruction> instructions = lastStatus.getInstructions();
        instructions.remove(instruction);
        instructions.add(instruction);
        lastStatus = new Status(lastStatus.getId(), lastStatus.getLocation(), lastStatus.isInMotion(), instructions);	}

	@Override
	public void run() {
		System.out.println("before while");
		while(true){
			for(Routine routine : routines){
				System.out.println("while_routine");
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
