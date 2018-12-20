package robot.routines;

import model.StopInstruction;
import model.Status;
import robot.routines.actions.Action;
import robot.routines.actions.StopAction;

public class StopRoutine implements Routine {
	@Override
	public Action calculateAction(Status status) {
		StopInstruction i = (StopInstruction) status.getInstruction(StopInstruction.class);
		if(i != null && i.getActive()){
			return new StopAction();
		}
		return null;
	}
}
