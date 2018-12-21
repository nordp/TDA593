package robot.routines;

import model.MovementInstruction;
import model.Status;
import robot.routines.actions.Action;
import robot.routines.actions.MoveAction;
import robot.routines.actions.StopAction;

public class CollisionPreventionRoutine implements Routine {
	@Override
	public Action calculateAction(Status status) {

		if(status.getCamera()){
			return new MoveAction(status.getLocation());
		}
		return null;

	}
}
