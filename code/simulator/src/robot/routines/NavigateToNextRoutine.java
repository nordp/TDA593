package robot.routines;

import model.Status;
import robot.routines.actions.Action;
import robot.routines.actions.MoveAction;

public class NavigateToNextRoutine implements Routine {
	//TODO Implement
	@Override
	public Action calculateAction(Status status) {
		System.out.println("calcAction");
		return new MoveAction(status.getLocation());
	}
}
