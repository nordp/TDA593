package chalmers.tda593.y2018.g11.rovu.robot.routines;

import chalmers.tda593.y2018.g11.rovu.model.Status;
import chalmers.tda593.y2018.g11.rovu.robot.routines.actions.Action;
import chalmers.tda593.y2018.g11.rovu.robot.routines.actions.StopAction;

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
