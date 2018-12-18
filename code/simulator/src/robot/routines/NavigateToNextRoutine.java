package robot.routines;

import model.MovementInstruction;
import model.Status;
import robot.routines.actions.Action;
import robot.routines.actions.MoveAction;

public class NavigateToNextRoutine implements Routine {
	//TODO Implement
	@Override
	public Action calculateAction(Status status) {

		MovementInstruction i = (MovementInstruction) status.getInstruction(MovementInstruction.class);
		if(i != null && i.getActive()){
			return new MoveAction(i.getNextStep());
		}
		return null;

	}
}
