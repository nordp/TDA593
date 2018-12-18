package robot.routines;

import model.MovementInstruction;
import model.Status;
import robot.routines.actions.Action;
import robot.routines.actions.StopAction;

public class MissionReachedRoutine implements Routine {
	//TODO Implement
	@Override
	public Action calculateAction(Status status) {

		MovementInstruction i = (MovementInstruction) status.getInstruction(MovementInstruction.class);
		if(i != null && i.getActive()){
			if (i.getNextStep().equals(status.getLocation())) {
				return new StopAction();
			}
		}
		return null;
	}
}
