package chalmers.tda593.y2018.g11.rovu.robot.routines;

import chalmers.tda593.y2018.g11.rovu.model.StopInstruction;
import chalmers.tda593.y2018.g11.rovu.model.Status;
import chalmers.tda593.y2018.g11.rovu.robot.routines.actions.Action;
import chalmers.tda593.y2018.g11.rovu.robot.routines.actions.StopAction;

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
