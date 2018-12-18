package robot.routines;

import model.EmergencyInstruction;
import model.Instruction;
import model.Status;
import robot.routines.actions.Action;
import robot.routines.actions.StopAction;

public class EmergencyStopRoutine implements Routine {
	@Override
	public Action calculateAction(Status status) {
		EmergencyInstruction i = (EmergencyInstruction) status.getInstruction(EmergencyInstruction.class);
		if(i != null && i.getActive()){
			return new StopAction();
		}
		return null;
	}
}
