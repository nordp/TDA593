package robot.routines;

import model.Status;
import robot.routines.actions.Action;
import robot.routines.actions.StopAction;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class EmergencyStopRoutine implements Routine {
	@Override
	public Action calculateAction(Status status) {
		StopAction stopAction = new StopAction();
		return stopAction;
	}
}
