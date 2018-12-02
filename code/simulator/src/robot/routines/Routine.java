package robot.routines;

import model.Status;
import robot.routines.actions.Action;

public interface Routine {
	Action calculateAction(Status status);
}
