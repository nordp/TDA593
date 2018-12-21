package chalmers.tda593.y2018.g11.rovu.robot.routines;

import chalmers.tda593.y2018.g11.rovu.model.MovementInstruction;
import chalmers.tda593.y2018.g11.rovu.model.Status;
import chalmers.tda593.y2018.g11.rovu.robot.routines.actions.Action;
import chalmers.tda593.y2018.g11.rovu.robot.routines.actions.StopAction;

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
