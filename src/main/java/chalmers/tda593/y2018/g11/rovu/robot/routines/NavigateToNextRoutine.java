package chalmers.tda593.y2018.g11.rovu.robot.routines;

import chalmers.tda593.y2018.g11.rovu.model.MovementInstruction;
import chalmers.tda593.y2018.g11.rovu.model.Status;
import chalmers.tda593.y2018.g11.rovu.robot.routines.actions.Action;
import chalmers.tda593.y2018.g11.rovu.robot.routines.actions.MoveAction;

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
