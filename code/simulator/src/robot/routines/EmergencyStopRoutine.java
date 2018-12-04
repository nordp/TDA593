package robot.routines;

import model.EmergencyInstruction;
import model.Status;
import robot.routines.actions.Action;
import robot.routines.actions.StopAction;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class EmergencyStopRoutine implements Routine {
	@Override
	public Action calculateAction(Status status) {
		if(status.getInstructions().contains(new EmergencyInstruction(true))){
			return new StopAction();
		}
		return null;
	}
}
