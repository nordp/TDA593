package robot.routines;

import model.Status;
import robot.routines.actions.Action;
import robot.routines.actions.StopAction;

public class RobotFailureRoutine implements Routine {

	@Override
	public Action calculateAction(Status status) {
		boolean failure = status.getSensor(); // How is this?
		if (failure) {
			return new StopAction();
		}
		return null;
	}
}
