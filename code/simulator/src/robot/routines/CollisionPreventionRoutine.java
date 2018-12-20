package robot.routines;

import model.MovementInstruction;
import model.Status;
import robot.routines.actions.Action;
import robot.routines.actions.StopAction;

public class CollisionPreventionRoutine implements Routine {
	@Override
	public Action calculateAction(Status status) {

		// first, gracefully stop
		if(status.getCamera() || status.getSensor()){
			return new StopAction();
		}
		return null;

	}
}
